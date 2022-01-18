package homework1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
        
public class Server extends JFrame implements ActionListener {
  
  JScrollPane jsp;
  JTextArea jta;
  JTextField jtf = new JTextField();
  JPanel jp;
  String str;
  
  //스레드 간의 정보 공유를 위해 hash map객체생성
  HashMap userMap = new HashMap();  
  
  public Server()
  {
    super("채팅 서버");
    
    jsp = new JScrollPane(jta=new JTextArea("서버 입니다.\n",15,15));
    add(jsp,BorderLayout.CENTER);
    
    add(jtf,BorderLayout.SOUTH);
    jtf.addActionListener(this);
    
    jta.setBackground(Color.white);
    setVisible(true);
    setBounds(100, 100, 500, 280);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    try{
      //클라이언트가 접속할수 있도록 서버소켓생성
      ServerSocket server = new ServerSocket(10001);
      jta.append("접속을 기다립니다.");
      System.out.println("접속을 기다립니다.");
      
      //스레드 간의 정보 공유를 위해 hash map객체생성
      //HashMap userMap = new HashMap();  
      while(true){
        //accept 메소드를 이용해서 클라이언트의 접속을 기다린다.
        Socket sock = server.accept();
        ChatThread chatthread = new ChatThread(sock, userMap);
        chatthread.start();
      } 
    }catch(Exception e){  
      System.out.println(e);
    }
  }
        
  public static void main(String[] args) {      
      new Server();
  } 
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==jtf)
    {
      str=jtf.getText();
      jta.append("\n(공지) "+str+"\n");
      broadcast("\n(공지) "+str+"\n");
      jtf.setText(null);
      
    }
    
  }
  
  public void broadcast(String msg){      
    synchronized(userMap){    
      Collection collection = userMap.values();  
      Iterator iter = collection.iterator();  
      while(iter.hasNext()){  
        PrintWriter pw = (PrintWriter)iter.next();
        pw.println(msg);
        pw.flush();
      }  
    }    
  }
  
  class ChatThread extends Thread {      
    private Socket sock;    
    private String userId;    
    private BufferedReader br;    
    private HashMap hm;    
    private boolean initFlag = false;
  
    public ChatThread(Socket sock, HashMap hm){    
      this.sock = sock;  
      this.hm = hm;  
      try{  
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));  
        br = new BufferedReader(new InputStreamReader(sock.getInputStream()));  
        userId = br.readLine();  
        
        broadcast(userId + "님이 접속하였습니다.");
        jta.append("\n접속한 사용자의 아이디는 " + userId + "입니다.\n");
        System.out.println("접속한 사용자의 아이디는 " + userId + "입니다.");  
        synchronized(hm){  
          hm.put(this.userId, pw);
          System.out.println(hm.get(this.userId));
        }  
        initFlag = true;  
      }catch(Exception ex){    
        System.out.println(ex);  
      }    
    }    
    
    public void run(){      
      try{    
        String line = null;  
        while((line = br.readLine()) != null){    
          if(line.equals("/quit"))  
            break;
          if(line.indexOf("/to ") == 0){  
            sendmsg(line);
          }else  
            broadcast(userId + " : " + line);
        }    
      }catch(Exception ex){      
        System.out.println(ex);    
      }finally{      
        synchronized(hm){    
          hm.remove(userId);  
        }
        System.out.println(userId + " 님이 접속 종료하였습니다.");
        jta.append("\n"+ userId + " 님이 접속 종료하였습니다.\n");
        broadcast(userId + " 님이 접속 종료하였습니다.");    
        try{    
          if(sock != null)  
            sock.close();
        }catch(Exception ex){}    
      }      
    }  
    
    public void sendmsg(String msg){        
      int start = msg.indexOf(" ") +1;      
      int end = msg.indexOf(" ", start);      
      if(end != -1){      
        String to = msg.substring(start, end);    
        String msg2 = msg.substring(end+1);    
        Object obj = hm.get(to);    
        if(obj != null){    
          PrintWriter pw = (PrintWriter)obj;  
          pw.println(userId + " 님이 귓속말을 보내셨습니다. :" + msg2);  
          pw.flush();  
        } 
      }    
    }   
    
    public void broadcast(String msg){      
      synchronized(hm){    
        Collection collection = hm.values();  
        Iterator iter = collection.iterator();  
        while(iter.hasNext()){  
          PrintWriter pw = (PrintWriter)iter.next();
          pw.println(msg);
          pw.flush();
        }  
      }    
    }     
  }
  
}      
      