package test04;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame{
	//필드 선언
	private JPanel contentPane;
	private JTextField textField;
	private JButton start;
	JTextArea textArea;
	
	private ServerSocket serverSocket;
	private Socket socket;
	private int port;
	
	//스레드간의 정보를 공유할 Vector 객체 생성
	private Vector vector = new Vector();  //가변 배열 	
	
	//생성자
	public Server(){
		init();   //사용자 정의 메소드 호출
	}
	public static void main(String[] args) {
		Server frame = new Server();
		frame.setVisible(true);
	}
	public void init(){
		setTitle("채팅-서버");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 300, 400);
		
		contentPane = new JPanel();
		contentPane.setLayout(null); //사용자 자유 배치
		setContentPane(contentPane);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(0, 0, 264, 254);
		contentPane.add(js);
		
		textArea = new JTextArea();
		textArea.setColumns(20);
		textArea.setRows(5);
		js.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(98, 264, 154, 37);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel portLable = new JLabel("Port Number");
		portLable.setBounds(12, 264, 98, 37);
		contentPane.add(portLable);
		
		start = new JButton("서버 실행");
		
		//이벤트 연결 및 핸들러 처리를 한번에 해결
		start.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || 
						textField.getText().length() == 0){
					JOptionPane.showMessageDialog(null, 
							"포트 번호를 입력하세요", 
							"경고 메시지", 
							JOptionPane.ERROR_MESSAGE);
					textField.requestFocus();
					return;
				}else{
					try{
						port = Integer.parseInt(textField.getText());
						server_start(port); //사용자 정의 메소드 호출
					}catch(Exception ex){
						System.out.println(ex);
					}
				}				
			}
		});	
		start.setBounds(0, 325, 264, 37);
		contentPane.add(start);
		textArea.setEditable(false);
	}//end init()
	
	public void server_start(int port)throws IOException{
		serverSocket = new ServerSocket(port);
		start.setText("서버실행중...");
		start.setBackground(Color.GREEN);
		start.setEnabled(false);  //"서버 실행" 버튼 비활성화
		textField.setEditable(false);
		
		if(serverSocket != null){
			Connection();   //사용자 정의 메소드 호출
		}
	}//end server_start()
	
	public void Connection(){
		Thread th = new Thread(new Runnable() {			
			@Override
			public void run() {
				while(true){   //무한 Loop
					try{
						textArea.append("사용자 접속 대기중...\n");
						socket = serverSocket.accept(); //"수락 " 허용
						textArea.append("사용자 접속!!\n");
						
						//접속을 계속 유지하면서 데이터 송수신하기 위해서 스레드 핸들러 객체생성
						ThreadHandler user = new ThreadHandler(socket,vector);
						vector.add(user);
						//해당 벡터에 사용자 객체 추가
						user.start();
					}catch(IOException e){
						textArea.append("accept(수락 )에러 발생!!\n");
					}
				}				
			}
		});
		th.start();
	}//end Connection()
	
	class ThreadHandler extends Thread{
		private Socket user_socket;
		private Vector user_vactor;
		private String Nickname = "";
		
		private InputStream is;       //기본 연결 입력 스트림
		private OutputStream os;      //기본 연결 출력 스트림
		private DataInputStream dis;  //보조 스트림
		private DataOutputStream dos; //보조 스트림		
		
		//생성자
		public ThreadHandler(Socket socket, Vector vector){
			user_socket = socket;
			user_vactor = vector;
			
			user_network(); //사용자 정의 메소드 호출
		}
		//=================================================
		/*
		 * Socket 데이터 통신
		 * => 클라이언트가 연결 요청을 하고 서버가 연결 수락을 했다면,
		 *    양쪽의 Socket 객체로부터 각각 입력스트림(InputStream)과
		 *    출력스트림(OutputStream)을 얻을 수 있다.
		 */
		public void user_network(){
			try{				
				/*
				 * 보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에
				 * InputStream, OutputStream 등에 연결해서 
				 * 입출력을 수행한다.
				 */
				is = user_socket.getInputStream(); //입력 스트림 객체 얻어오기
				dis = new DataInputStream(is); //보조 스트림 객체 생성
				
				os = user_socket.getOutputStream(); //출력 스트림 객체 얻어오기
				dos = new DataOutputStream(os); //보조 스트림 객체 생성
				
				Nickname = dis.readUTF();
				textArea.append("접속자 ID " + Nickname + "\n");
				//사용자 정의 메소드 호출
				send_Message("정상 접속 되었습니다."); 
			}catch(Exception e){
				textArea.append("스트림 설정 에러 발생!!\n");
			}
		}//end User_network()
		public void send_Message(String str){
			try{
				dos.writeUTF(str);
			}catch(IOException e){
				textArea.append("메시지 송신 에러 발생\n");
			}
		}
		public void broad_cast(String str){
			for(int i=0; i<user_vactor.size(); i++){
				ThreadHandler imsi = (ThreadHandler)user_vactor.elementAt(i);
				imsi.send_Message(Nickname + ":" + str);				
			}
		}
		public void InMessage(String str){
			textArea.append("사용자로부터 들어온 메시지: " + str+"\n");
			broad_cast(str);
		}
		@Override	//수동으로 Override 시킨다!!
		public void run(){
			while(true){
				try{
					String msg = dis.readUTF();
					InMessage(msg);
				}catch(IOException e){
					try{
						dos.close();
						dis.close();
						user_socket.close();
						user_vactor.removeElement(this);
						textArea.append(user_vactor.size()+":현재 벡터에 담겨진 사용자\n");
						textArea.append("사용자 접속 끊어짐\n");
						break;
					}catch(Exception ex){
						System.out.println(ex);
					}
				}
			}
		}		
	}	
}