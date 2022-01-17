package test04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainView extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	
	private String id;
	private String ip;
	private int port;
	
	JButton sendBtn;   //"전송" 버튼
	JTextArea textArea;
	
	private Socket socket;
	private InputStream is;       //기본 연결 입력 스트림
	private OutputStream os;      //기본 연결 출력스트림
	private DataInputStream dis;  //보조 스트림
	private DataOutputStream dos; //보조 스트림
	
	//생성자
	public MainView(String id, String ip, int port){
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		init();		//사용자 정의 메소드 호출
		start();	//사용자 정의 메소드 호출
		
		textArea.append("매개변수로 넘어온 값: "+id+" "+ip+" "+port+"\n");
		network();  //사용자 정의 메소드 호출		
	}
	public void init(){
		setTitle("채팅-클라이언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 288, 390);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);  //사용자 자유 배치
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 272, 300);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(0, 312, 155, 42);
		textField.setColumns(10);
		contentPane.add(textField);
		
		sendBtn = new JButton("전송");
		sendBtn.setBounds(161, 312, 111, 42);
		contentPane.add(sendBtn);
		
		textArea.setEnabled(false); //textArea 객체 비활성화
		setVisible(true);
	}
	public void start(){
		sendBtn.addActionListener(new Myaction());
		//이벤트 연결 및 핸들러 처리를 한번에 해결
		textField.addKeyListener(new KeyAdapter() {
			@Override
			//textField 객체에서 메시지 입력 후 "전송" 버튼을 누르지 않고
			//"Enter" 키를 누른 경우 해결 방법
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					//사용자 정의 메소드 호출
					send_Message(textField.getText());
					textField.setText("");
					textField.requestFocus();
				}
			}
		});
	}//end start()
	public void send_Message(String str){
		try{
			dos.writeUTF(str);
		}catch(IOException e){
			textArea.append("메시지 송신 에러");
		}
	}
	class Myaction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == sendBtn){
				send_Message(textField.getText());
				textField.setText("");
				textField.requestFocus();
			}			
		}		
	}
	public void network(){
		//서버에 접속하기 위해서 준비 작업
		try{
			socket = new Socket(ip, port);
			if(socket != null){
				Connection(); //사용자 정의 메소드 호출
			}
		}catch(UnknownHostException e){
			
		}catch(IOException e){
			textArea.append("소켓 접속 에러!!\n");
		}
	}//end network()
	public void Connection(){
		try{
			//보조 IO 스트림 객체 생성하는 방법
			is = socket.getInputStream(); //기본 연결 스트림 객체 얻어오기
			dis = new DataInputStream(is); //보조 스트림 객체 생성
			
			os = socket.getOutputStream(); //기본 연결 스트림 객체 얻어오기
			dos = new DataOutputStream(os); //보조 스트림 객체 생성
			
		}catch(IOException e){
			textArea.append("스트림 설정 에러");
		}
		send_Message(id);
		
		Thread th = new Thread(new Runnable() {			
			@Override
			public void run() {
				while(true){ //무한 Loop
					try{
						//서버로 부터 메시지 수신 
						String msg = dis.readUTF(); 
						textArea.append(msg + "\n");
					}catch(IOException e){
						textArea.append("메시지 수신 에러!!\n");
						try{
							os.close();
							is.close();
							dos.close();
							dis.close();
							socket.close();
							break;
						}catch(IOException ex){
							System.out.println(ex);
						}						
					}					
				}
			}
		});
		th.start();
	}	
}