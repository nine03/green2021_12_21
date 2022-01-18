package homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
 

public class Server {
    HashMap<String,DataOutputStream> clientMap;
    ServerSocket serverSocket = null;
    Socket socket = null;
   
    
    public Server(){
        clientMap = new HashMap<String,DataOutputStream>(); 
        Collections.synchronizedMap(clientMap); 
    }
   
    public void init(){
        try{
            serverSocket = new ServerSocket(9999); 
            System.out.println("서버가 시작되었습니다.");
           
            while(true){ 
                socket = serverSocket.accept(); 
                System.out.println(socket.getInetAddress()+":"+socket.getPort()); 
               
                Thread msr = new MultiServerRec(socket); //쓰레드 생성.
                msr.start(); //쓰레드 시동.
            }      
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
    //접속된 모든 클라이언트들에게 메시지를 전달.
    public void sendAllMsg(String msg){
       
        //출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
        Iterator it = clientMap.keySet().iterator();
       
        while(it.hasNext()){
            try{
                DataOutputStream it_out = (DataOutputStream) clientMap.get(it.next());
                it_out.writeUTF(msg);
            }catch(Exception e){
                System.out.println("예외:"+e);
            }
        }
    }//sendAllMsg()-----------
   
   
    //지정된 이름에만 메시지 보내기.
    public void sendToMsg(String fromName, String toName, String msg){     
           try{            
                           
                clientMap.get(toName).writeUTF("귓:from("+fromName+")=>"+msg);
                clientMap.get(fromName).writeUTF("귓:to("+toName+")=>"+msg);
               
            }catch(Exception e){
                System.out.println("예외:"+e);
            }
       
    }//sendAllMsg()-----------
   
   
   
    //접속된 유저리스트  문자열로 반환
    public String showUserList(String name){
       
        StringBuilder output = new StringBuilder("==접속자목록==\r\n");
        Iterator it = clientMap.keySet().iterator(); //해쉬맵에 등록된 사용자이름을 가져옴.
       
        while(it.hasNext()){ //반복하면서 사용자이름을 StringBuilder에 추가
            try{
                String key= (String) it.next();
                               
               //out.writeUTF(output);
                if(key.equals(name)){
                    key += " (*) ";
                }              
                output.append(key+"\r\n");
               
            }catch(Exception e){
                System.out.println("예외:"+e);
            }
        }//while---------
        output.append("=="+clientMap.size()+"명 접속중==\r\n");
        return output.toString();
       
       
    }//showUserList()-----------
    public String showUserList(){
       
        return showUserList("");
    }
   
    //문자열 null 값 및 "" 은 대체 문자열로 삽입가능.
    public String NVL(String str, String replace){
        String output="";
        if(str==null || str.trim().equals("")){
            output = replace;      
        }else{
            output = str;
        }
        return output;     
    }
   
    //main메서드
    public static void main(String[] args) {
        Server ms = new Server(); //서버객체 생성.
        ms.init();//실행.
    }//main()------
   
   
    ////////////////////////////////////////////////////////////////////////
    //----// 내부 클래스 //--------//
   
    // 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드
    class MultiServerRec extends Thread {
       
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
       
        //생성자.
        public MultiServerRec(Socket socket){
            this.socket = socket;
            try{
                //Socket으로부터 입력스트림을 얻는다.
                in = new DataInputStream(socket.getInputStream());
                //Socket으로부터 출력스트림을 얻는다.
                out = new DataOutputStream(socket.getOutputStream());
            }catch(Exception e){
                System.out.println("예외:"+e);
            }
        }//생성자 ------------
       
       
       
        @Override
        public void run(){ //쓰레드를 사용하기 위해서 run()메서드 재정의
           
           
            String name=""; //클라이언트로부터 받은 이름을 저장할 변수.
 
            try{
                out.writeUTF("이름을 입력해주세요");  //클라이언트가 접속하면 메시지 출력.                    
                name = in.readUTF(); //클라이언트에서 처음으로 보내는 메시지는
                                     //클라이언트가 사용할 이름이다.
                out.writeUTF("채팅방에 입장하였습니다.");
                sendAllMsg(name + "님이 입장하셨습니다.");
                //현재 객체가 가지고있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
                clientMap.put(name, out); //해쉬맵에 키를 name으로 출력스트림 객체를 저장.
                System.out.println("현재 접속자 수는 "+clientMap.size()+"명 입니다.");
               
                while(in!=null){ //입력스트림이 null이 아니면 반복.
                   
                    String msg = in.readUTF(); //입력스트림을 통해 읽어온 문자열을 msg에 할당.
                   
                    if(msg.startsWith("/")){                       
                        if(msg.trim().equals("/접속자")){  
                            //System.out.println(showUserList());          
                            out.writeUTF(showUserList(name)); //접속자 출력                       
                        }else if(msg.startsWith("/to")){                                        
                            //public String[] split(String regex, int limit)
                            String[] msgArr = msg.split(" ",3); //받아온 msg을 " "(공백)을 기준으로 3개를 분리
                            //공백으로 스플리트 했을시 메시지에서 문제. 하지만 리미트를  정하게 되면 해결.
                            /*for (int i = 0; i < arr.length; i++) {
                                System.out.println(arr[i]);
                            }*/    
                            if(msgArr==null||msgArr.length<3){
                                out.writeUTF("Help:귓속말 사용법이 잘못되었습니다.\r\n /귓속말 [상대방이름] [보낼메시지].");
                            }else{
                                String toName = msgArr[1];
                                //String toMsg = "귓:from("+name+")=>"+((msgArr[2]!=null)?msgArr[2]:"");
                                String toMsg = msgArr[2];
                                if(clientMap.containsKey(toName)){ //유저체크
                                    sendToMsg(name,toName,toMsg);
                                   
                                }else{
                                    out.writeUTF("해당 유저가 존재하지 않습니다.");
                                }
                               
                            }
                           
                        }else{
                            out.writeUTF("잘못된 명령어입니다.");
                        }
                       
                    }else{
                        sendAllMsg("[ "+ name +" ] "+ msg); //현재 소켓에서 읽어온메시지를 해쉬맵에 저장된 모든
                        //출력스트림으로 보낸다. 
                    }
                   
                }//while()---------
            }catch(Exception e){
                System.out.println(e + "----> ");
            }finally{
                //예외가 발생할때 퇴장. 해쉬맵에서 해당 데이터 제거.
                //보통 종료하거나 나가면 java.net.SocketException: 예외발생
                clientMap.remove(name);
                sendAllMsg(name + "님이 퇴장하셨습니다.");              
                System.out.println("현재 접속자 수는 "+clientMap.size()+"명 입니다.");
            }
        }//run()------------
    }//class MultiServerRec-------------
    //////////////////////////////////////////////////////////////////////
}