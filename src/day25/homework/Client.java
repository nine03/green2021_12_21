package homework;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
 
 
public class Client extends JFrame implements ActionListener,Runnable {
    JTextArea ta;
    JTextField txtInput;
    DataInputStream in;
    DataOutputStream out;
   
   
    //생성자에서 초기 UI구성
    public Client() {
       
       
        //-------------------- UI ---------------------------//
        setTitle("초간단  채팅 클라이언트 프로그램 v1.0");
        ta=new JTextArea(); //텍스트영역 생성 (대화내용출력하는란)
        txtInput=new JTextField(); //텍스트필드 생성 (대화내용입력하는란)
       
        //public JScrollPane(Component view,int vsbPolicy,int hsbPolicy)
        //textArea에 스크롤 기능 확장. 스크롤 규칙은 가로스크롤 보이지 않게, 세로는 항상보이게
        JScrollPane sp = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setAutoscrolls(true); //자동 스크롤 설정.
       
        ta.setBackground(new Color(200,200,255)); //텍스트영역 배경설정.
        ta.setLineWrap(true); //텍스트영역 자동 줄바꿈.
        //ta.setText("이름을 입력해 주세요.\r\n");; //텍스트 영역에 글쓰기 메서드.
       // ta.append("[사용자이름] 채팅내용이 보여지는 부분\r\n");//텍스트 영역에 글추가 메서드.
        ta.setEditable(false); //대화출력 영역 사용못하게 비활성화.
       
        txtInput.setText("입력부분"); //입력란 글추가.
       
        add(sp,"Center"); //스크롤 기능이 확장된 텍스트영역 frame , "Center" 영역에 추가.
        add(txtInput,"South"); //입력란을 frame의 South영역에 추가.
        setSize(400, 500); //frame(창) 크기 가로 400, 세로 500
        setVisible(true); //frame(창) 화면에 보이게
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 작동되게
        txtInput.requestFocus(); //프로그램시작시 입력란에 포커스주기
        txtInput.selectAll(); //시작시 입력란 내용 전체선택, 바로 사용자가 입력할수있게
        txtInput.addActionListener(this); //텍스트입력란에 액션을 감지해줄 리스너를 부착.
         //액션이 발생하면.actionPerformed() 메서드에 구현한 내용이 실행
        //-------------------- UI ---------------------------//
       
       
       
       //네트워크 코드
        try{
            Socket socket = new Socket("localhost",9999);
            //입력스트림
            in = new DataInputStream(socket.getInputStream());         
            //출력스트림
            out = new DataOutputStream(socket.getOutputStream());
            ta.append("서버에 접속되었습니다.\r\n");
        }catch(Exception e){
            System.out.println("예외:"+e);
        }
       
        Thread thread = new Thread(this); //스레드 생성.
        thread.start(); //시동.
       
       
    }//생성자--------------------
   
   
    public static void main(String[] args) {
        new Client(); //클라이언트 실행.
    }//main()--------------
 
   
 
    @Override
    public void actionPerformed(ActionEvent e) { //엔터또는 버튼을 클랙했을경우 실행되는 메서드
        //System.out.println(e.getSource());
        //System.out.println(e.getSource().equals(txtInput));
        //System.out.println(txtInput.getText()); //입력란 문자열 가져오기
       
     
        if(e.getSource().equals(txtInput)){
            String msg = txtInput.getText(); //입력한 내용을 가져온다.       
           
            try {
                out.writeUTF(msg); //서버로 메시지 보내기
                txtInput.setText(""); //입력란 초기화
               
            } catch (IOException ex) {
                System.out.println("예외:"+ex);
            }
        }//if--------------    
       
    }//actionPerformed()-----------
 
 
    @Override
    public void run() {// run()메소드 구현
        try {
           
            String msg = in.readUTF();
            ta.append(msg + "\r\n");
           
            while (in != null) { // 입력스트림이 null이 아니면..반복
                msg = in.readUTF();
                // System.out.println(msg);
                ta.append(msg + "\n"); // 출력창(textarea영역)에 msg추가
 
            }// while----
        } catch (SocketException e) {
            System.out.println("예외:" + e);
            System.out.println("접속중인 서버와 연결이 끊어졌습니다.");
            return;
 
        } catch (Exception e) {
            System.out.println("예외:" + e);
 
        }
 
    }// run()---------
}
