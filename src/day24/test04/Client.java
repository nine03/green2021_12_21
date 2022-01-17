package test04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame{
	private JPanel contentPane;
	private JTextField tf_ID;
	private JTextField tf_IP;
	private JTextField tf_PORT;
	
	//생성자
	public Client(){
		init();
	}
	public static void main(String[] args) {
		Client client = new Client();
		client.setVisible(true);
	}
	public void init(){  //화면구성
		setTitle("채팅-Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 288, 390);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);  //사용자 자유 배치
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(53, 57, 90, 34);
		contentPane.add(idLabel);
		
		tf_ID = new JTextField();
		tf_ID.setBounds(92, 64, 150, 20);
		tf_ID.setColumns(10);
		contentPane.add(tf_ID);
		
		JLabel serverIP = new JLabel("Server IP");
		serverIP.setBounds(12, 111, 90, 34);
		contentPane.add(serverIP);
		
		tf_IP = new JTextField();
		tf_IP.setBounds(92, 118, 150, 20);
		tf_IP.setColumns(10);
		contentPane.add(tf_IP);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(36, 178, 90, 34);
		contentPane.add(lblPort);
		
		tf_PORT = new JTextField();
		tf_PORT.setBounds(92, 185, 150, 20);
		tf_PORT.setColumns(10);
		contentPane.add(tf_PORT);
		
		JButton btnNewButton = new JButton("서버 접속 버튼");		
		btnNewButton.setBounds(36, 266, 200, 40);		
		contentPane.add(btnNewButton);
		
		//이벤트 연결 및 핸들러 처리를 한번에
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String _id = tf_ID.getText().trim(); //공백 제거
					String _ip = tf_IP.getText().trim();
					int _port = Integer.parseInt(tf_PORT.getText().trim());
					
					MainView view = new MainView(_id, _ip, _port);
					setVisible(false);					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, 
							"포트번호를 숫자로 입력하세요", 
							"경고 메세지", 
							JOptionPane.ERROR_MESSAGE);
					tf_PORT.setText(null);
					tf_PORT.requestFocus();
					return;					
				}				
			}
		});		
	}
	
}