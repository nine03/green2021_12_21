package ex03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MultiChatServer {
	private static final int LOGIN = 100; 
	private static final int LOGOUT = 200;
	private static final int EXIT = 300;
	private static final int  NOMAL = 400;;
	private static final int WISPER = 500;;
	private static final int VAN = 600;
	private static final int CPLIST= 700;
	private static final int ERR_DUP = 800;

	private ServerSocket serverSocket = null;
	private Socket socket = null;
	
	ArrayList <ChatThread> chatlist = new ArrayList <ChatThread>(); //스레드 리스트
	HashMap<String, ChatThread> hash= new HashMap<String, ChatThread>(); 
	//ID를 KEY로 해서 스레드를 VALUE로 갖고 있는 HASHMAP
	Date now = new Date(System.currentTimeMillis());
	SimpleDateFormat simple= new SimpleDateFormat("(a hh:mm)");
	//채팅내용 옆에 시간을 같이 출력하기 위해서 현재시간에 포맷을 지정
	
	public void start() {
		try {
			
			serverSocket = new ServerSocket(8888);
			System.out.println("server start");
			
		
			while(true) {
				socket = serverSocket.accept();				
				
				ChatThread chat = new ChatThread(socket);
				
				chatlist.add(chat);
				
				chat.start();
			}
		} catch(IOException e) {
		
			System.out.println("통신소켓 생성불가");
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			
		}catch(Exception e) {
			System.out.println("서버소켓 생성불가");
			if(!serverSocket.isClosed()) {
				stopServer();
			}
		}
		
	} 
	
	public void stopServer() {
		try {
			Iterator<ChatThread> iterator = chatlist.iterator(); 
			//chatlist에 있는 스레드 전체를 가져오기 위해 iterator 객체 생성
			while (iterator.hasNext()) { //다음 객체가 있는 동안
				ChatThread chat = iterator.next(); // 다음 객체를 스레드에 대입
				chat.soket.close(); //해당 스레드 통신소켓제거
				iterator.remove(); //스레드 제거
				
			}
			if(serverSocket!=null && !serverSocket.isClosed()) {
				serverSocket.close(); //서버소켓 닫기
			}
			System.out.println("서버종료");
		}catch (Exception e) {}
	}
	public static void main(String[] args) {
		MultiChatServer server = new MultiChatServer();
		server.start();
	}
	

	void broadCast(String msg) { //채팅방 인원 전체출력
		for(ChatThread ct : chatlist) {
			ct.outMsg.println(msg+ simple.format(now)); 
			//매개변수로 받은 채팅내용을 시간과 함께 출력
		}
	}
	void wisper(ChatThread from, ChatThread to,String msg) { //송신그레드,수신스레드,대화내용 매개변수)
		from.outMsg.println(msg+ simple.format(now)); //송신스레드 채팅창에 출력
		to.outMsg.println(msg+ simple.format(now)); // 수신스레드 채팅창에 출력
	}
	
	void updatinglist() {
		
		Set<String> list = hash.keySet();// hashmap에서 아이디(key)만 set으로 가져옴
		for(ChatThread ct : chatlist) {
				ct.outMsg.println(CPLIST+"/"+list); //CPLIST명령어로 전체에게 출력
			}
		}
	void disconnect(ChatThread thread, String id) {
		try {
			thread.soket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hash.remove(id); //hashmap에서 제거
		chatlist.remove(thread); //chatlist에서 제거 
		
	}
	
	
	class ChatThread extends Thread {
		
		public ChatThread(Socket socket) { 
			//통신소켓을 닫기 위해서 스레드 생성할 때 생성자 매개변수로 소켓을 받아서 멤버변수에 대입
			this.soket = socket;
		}
		
		Socket soket;
		String msg;
		String[] rmsg;
		
		
		
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;

		public void run() {
		
			boolean status = true;
			System.out.println("##ChatThread start...");
			try {
				
				inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream())); //예외발생 가능성
				outMsg = new PrintWriter(socket.getOutputStream(), true);
			

				while(status) { //수신부
					
					msg = inMsg.readLine();
					
					rmsg = msg.split("/");
					
					int commend = Integer.parseInt(rmsg[0]); 
					//가장앞에 있는 명령어를 스위치문으로 처리하기 위해 int로 형변환

		                switch (commend) {
						case LOGIN: {
							System.out.println(commend);
							if(hash.containsKey(rmsg[1])) { //id로 hashmap에서 중복검사
								this.outMsg.println(ERR_DUP+"/"+"[SERVER]" +"/" +"로그인불가>ID 중복"); 
								//로그인 한 상대방 채팅창에 로그인 불가 안내메시지 출력
								socket.close(); //소켓 제거
								chatlist.remove(this); //스레드리스트에서 제거 
								status = false; // 상태변경으로 while문 탈출
								break;
							}
							
							else{
								hash.put(rmsg[1], this); //중복이 아니면 해당 아이디를 key/ 스레드를 value로 추가
								broadCast(NOMAL+"/"+"[SERVER]" +"/"+rmsg[1]+"님이 로그인했습니다."); 
								//채팅창에 로그인 메세지 출력
								updatinglist(); //변경된 참가자 리스트를 송신
								break;
							}
							
						}
						case LOGOUT: {
							disconnect(this, rmsg[1]); //해당 스레드와 연결을 해제하는 메서드 
							broadCast(NOMAL+"/"+"[SERVER]" +"/"+ rmsg[1] + "님이 종료했습니다.");
							//나감을 알림
							updatinglist(); // 변경된 채팅 참가자 리스트 송신
							status = false; //while문 반복탈출
							break;
						}
						case EXIT: {
							disconnect(this, rmsg[1]);
							broadCast(NOMAL+"/"+"[SERVER]" +"/" + rmsg[1] + "님과 연결이 끊어졌습니다.");
							updatinglist();
							status = false;
							break;
						}
						case NOMAL: {
							 broadCast(msg);
							 break;
						}
						case WISPER: {			
							ChatThread from = hash.get(rmsg[1]); // rmsg[1] 송신 id를 key값으로 value스레드 찾기
							ChatThread to =  hash.get(rmsg[2]); // rmsg[2] 수신 id를 key값으로 value스레드 찾기
							wisper(from,to, msg); //찾은 송신 스레드 , 수신 스레드, 내용을 매개변수로 wisper메소드 호출
							break;
						}
						case VAN : {
							if(chatlist.indexOf(this)!=0) {//0번 스레드에 방장권한을 줌 (방장이 아니라면)
								this.outMsg.println(NOMAL+"/"+"[SERVER]" +"/"+ "강퇴권한이 없습니다."+ simple.format(now));
								//해당 스레드에만 권한이 없음을 송신
								break;
								
							}
							else {
								broadCast(NOMAL+"/"+"[SERVER]" +"/" + rmsg[2] + "님이 강제퇴장하셨습니다.");
								// 해당 스레드가 방장이라면 강퇴당한 사실을 전체에게 출력
								ChatThread thread = hash.get(rmsg[2]); 
								//hashmap에서 강퇴할 id로 해당 스레드를 검색해서 thread에 대입
								thread.outMsg.println(VAN+"/");
								disconnect(thread, rmsg[2]);//강퇴당한 스레드 연결해제 
								updatinglist();
								break;

							}	 
						}
					
						
					}//switch
				}//while
					
					

				this.interrupt();
				System.out.println("##"+this.getName()+"stop!!");
			}catch(IOException e) {
				try {
					this.soket.close();
				} catch (IOException e1) {}
				chatlist.remove(this);
				// e.printStackTrace();
				System.out.println("[ChatThread]run() IOException 발생!!");
			}
		}
	}
	
}