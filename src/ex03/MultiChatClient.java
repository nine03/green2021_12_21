package ex03;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MultiChatClient implements ActionListener, Runnable {
	private static final int LOGIN = 100; 
	private static final int LOGOUT = 200;
	private static final int EXIT = 300;
	private static final int  NOMAL = 400;;
	private static final int WISPER = 500;;
	private static final int VAN = 600;
	private static final int CPLIST= 700;
	private static final int ERR_DUP = 800;

	
	
    private String ip;
    private String id;
    private String contents;
    private Socket socket;
    private BufferedReader inMsg = null;
    private PrintWriter outMsg = null;

    private JPanel loginPanel;
    private JButton loginButton;
    private JLabel label1;
    private JTextField idInput;

    private JPanel logoutPanel;
    private JLabel label2;
    private JButton logoutButton;

    private JPanel msgPanel;
    private JTextField msgInput;
    private JButton exitButton;

    private JFrame jframe;
    private JTextArea msgOut;
    
    private JPanel chatpListPanel;
    private JLabel label3;
    private JTextArea listOut;

    private Container tab;
    private CardLayout clayout;
    private Thread thread;

    boolean status;

    public MultiChatClient(String ip) {
        this.ip = ip;

        loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        idInput = new JTextField(15);
        loginButton = new JButton("로그인");
        loginButton.addActionListener(this);
        label1 = new JLabel("대화명");

        loginPanel.add(label1, BorderLayout.WEST);
        loginPanel.add(idInput, BorderLayout.CENTER);
        loginPanel.add(loginButton, BorderLayout.EAST);

  
        logoutPanel = new JPanel();

        logoutPanel.setLayout(new BorderLayout());
        label2 = new JLabel();
        logoutButton = new JButton("로그아웃");

        logoutButton.addActionListener(this);
 
        logoutPanel.add(label2, BorderLayout.CENTER);
        logoutPanel.add(logoutButton, BorderLayout.EAST);

 
        msgPanel = new JPanel();
 
        msgPanel.setLayout(new BorderLayout());
        msgInput = new JTextField(30);
 
        msgInput.addActionListener(this);
        msgInput.setEditable(false); //로그인 하기 전에는 채팅입력 불가
        exitButton = new JButton("종료");
        exitButton.addActionListener(this);
  
        msgPanel.add(msgInput, BorderLayout.CENTER);
        msgPanel.add(exitButton, BorderLayout.EAST);

        tab = new JPanel();
        clayout = new CardLayout();
        tab.setLayout(clayout);
        tab.add(loginPanel, "login");
        tab.add(logoutPanel, "logout");


        jframe = new JFrame("::채팅프로그램::");
        msgOut = new JTextArea("", 10, 30);
        
        msgOut.setEditable(false);
        
        JScrollPane jsp = new JScrollPane(msgOut,
        		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        chatpListPanel = new JPanel(); //채팅 참자가 리스트가 붙을 패널
        chatpListPanel.setLayout(new BorderLayout());
        
        label3 = new JLabel("채팅 참가자"); // 라벨
        listOut =new JTextArea("",10,10); //채팅참가자를 나타낼 영역
        listOut.setEditable(false); //편집불가
        JScrollPane jsp2 = new JScrollPane(listOut,
        		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        chatpListPanel.add(label3,BorderLayout.NORTH); //패널에 라벨과 스크롤을 갖다 붙임
        chatpListPanel.add(jsp2,BorderLayout.CENTER);
        
        
        
        
        jframe.add(tab, BorderLayout.NORTH);
        jframe.add(jsp, BorderLayout.WEST);
        jframe.add(chatpListPanel,BorderLayout.EAST);
        jframe.add(msgPanel, BorderLayout.SOUTH);
       
        clayout.show(tab, "login");
        
        jframe.pack();
        
        jframe.setResizable(false);
        
        jframe.setVisible(true);

    }

    public void connectServer() {
        try {
           
            socket = new Socket(ip, 8888); //예외발생 가능성
            System.out.println("[Client]Server 연결 성공!!");

    
            inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream())); //예외발생 가능성
            outMsg = new PrintWriter(socket.getOutputStream(), true);

    
            outMsg.println(LOGIN+"/"+id); //LOGIN 명령어로 해당 ID 출력

 
            thread = new Thread(this);
            thread.start();
        } catch(IOException e) { //해당포트에 서버가 실행하고 있지 않은 경우
            // e.printStackTrace();
            System.out.println("서버연결불가");
            if(!socket.isClosed()) {
            	stopClient();
            }
            return;
        }
    }
    public void stopClient() {
    	System.out.println("연결끊음");

        msgOut.setText(""); //채팅창 비우기
        listOut.setText(" "); //참가자 창 비우기
        msgInput.setEditable(false); //채팅입력불가
        clayout.show(tab, "login"); 
        status = false;
        
        if(socket!=null && !socket.isClosed()) {
        	try {
				socket.close(); //예외 발생 가능성
			} catch (IOException e) {}
        } 
    	
    }


    public void actionPerformed(ActionEvent arg0) {
        Object obj = arg0.getSource();

 
        if(obj == exitButton) {
        	outMsg.println(EXIT+"/"+id );
        	stopClient();
        	System.exit(0);
            
        } 
        else if(obj == loginButton) {
            id = idInput.getText().trim();
            label2.setText("대화명 : " + id);
            clayout.show(tab, "logout");
            msgInput.setEditable(true); //채팅입력 창 활성화(채팅입력 가능)
            connectServer();
        } 
        
        else if(obj == logoutButton) {
   
            outMsg.println(LOGOUT+"/"+id );   
        
           stopClient();
            

          
            
            
        } 
        else if(obj == msgInput) {
        	Thread thread = new Thread() { 
        		//출력 쓰레드 새로생성(도배방지 기능 구현 관계상 출력 쓰레드만 sleep 시키기 위해)
        		//입력 스레드는 계속 일을 해야 채팅제한시간에도 내용이 채팅창에 추가되므로
        		@Override
        		public void run() {
        			contents = msgInput.getText();
        			//입력창의 내용 contents에 대입
            		
            		if(contents.indexOf("to")==0) { 
            			// 처음 시작이 to (예전 코드는 중간에 to가 들어갈경우 구분 불가)
            			int begin = contents.indexOf(" ") + 1;   
            			//  to 1111 안녕하세요 일 경우 처음 빈칸 다음자리부터
            			int end = contents.indexOf(" ", begin);
            			//끝자리 포함x(+1 안함)  // 다음 빈칸까지(마지막 자리는 포함 안됨)
            			String toid = contents.substring(begin, end);
            			//contents에서 해당 부분을 찾아 id에 대입
            			
            			String wisper = contents.substring(end+1); 
            			//두번째 빈칸 다음자리부터 끝까지를 뽑아서 wisper에 저장(내용)
            			outMsg.println(WISPER+"/"+id + "/"+ toid+ "/" + wisper); 
            			// 각 내용을 /로 구분해서 출력
            		}
            		else if(contents.indexOf("van")==0) { //처음 시작이 van
            			int begin = contents.indexOf(" ") + 1;  
            			//  to 1111 안녕하세요 일 경우 처음 빈칸 다음자리부터
            			String vanid = contents.substring(begin); 
            			//contents에서 해당 부분을 찾아 vanid에 대입
            			
            			outMsg.println(VAN+"/"+id + "/"+ vanid); // 각 내용을 /로 구분해서 출력
            		
            		}
            		else {
            			outMsg.println(NOMAL+"/"+id + "/" + contents);
            		
            			int len = contents.length();
            			if(len>30){
            				try {
    							
    							msgOut.append("30자를 초과하여 도배방지를 위해 1분간 입력을 제한합니다.\n"); 
    							//해당 클라이언트에서 채팅창에 메시지 출력
    							msgInput.setText(""); //입력창 비우기
    							msgInput.setEditable(false); // 채팅입력칸 수정불가
    							Thread.sleep(60000); //60초간 재우기
    							msgInput.setEditable(true);//다시 살림
    						
    							
            				} catch (Exception e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
            				
    	        		} //if
               
            		}//else
            		msgInput.setText("");
        		} //run
        	};// thread
        	thread.start();
        	
        } //else if(obj == msgInput)
    }//action
        	
        		
    
    public void run() {

        String msg;
        String[] rmsg;


        status = true;

        while(status) { //수신부
            try {
           
                msg = inMsg.readLine();
                rmsg = msg.split("/");
                int commend = Integer.parseInt(rmsg[0]);
                //0번 인덱스에 있을 명령어를 INT형으로 형변환
                switch (commend) {
                
	                case WISPER: { //귓속말이 온 경우
	                	msgOut.append(rmsg[1] + ">>"+rmsg[2] + "\n" + rmsg[3] +"\n");
	                	//귓속말을 보낸 사람과 받은사람을 채팅창에 표시	
	                	break;
	                
	                }
					case CPLIST: { //채팅참가자 리스트가 온 경우
						String []userlist = rmsg[1].split(",");
						// 1번 인덱스에 있는 참가자 ID SET을 ,를 구분자로 하여 userlist배열에 담기 
						int size = userlist.length;
						listOut.setText(" "); //참가자 리스트창 비우기
						
						for(int i = 0;i<size;i++) { // 요소 하나씩 읽어들여서 참가자 리스트에 추가
							listOut.append(userlist[i]);
							listOut.append("\n");
						}
						
						break;
					}
					case VAN:{
						clayout.show(tab, "login"); //로그인버튼 바꾸기
						stopClient();
						
					}
					case ERR_DUP:{ //id 중복으로 접속이 팅겼을 경우에 처리
						
						stopClient();
						msgOut.append(rmsg[1] + ">"+rmsg[2] + "\n");
						break;
					}
					default:
						msgOut.append(rmsg[1] + ">"+rmsg[2] + "\n");
						break;
				}//switch
                
                msgOut.setCaretPosition(msgOut.getDocument().getLength());
            } catch(Exception e) {
                // e.printStackTrace();
                status = false;
            }
        }//while

        System.out.println("[MultiChatClient]" + thread.getName() + "종료됨");
    }

    public static void main(String[] args) {
        MultiChatClient mcc = new MultiChatClient("127.0.0.1");
    }
}