package ex04.socketio.dm;

// 귓속말 기능 구현 
// .to user01 hello user01  .to userid message 
//
// 접속 종료 - 서버와 연결 끊어진다.
// .quit

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx01 {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	Scanner scan = new Scanner(System.in);
	static String[] fieldArgs;

	public ClientEx01() {
		try {
			// 서버 소켓과 연결 - Socket생성 즉시 서버와 연결 됨.
			socket = new Socket(InetAddress.getLocalHost(), 9000);
			System.out.println("클라이언트 >>> 서버와 연결되었다.");
			// 서버와 입/출력 스트림을 연결한다.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 서버에 userId 보내기
			String userId = "user" + (int)(Math.random()*1000);
			if(fieldArgs != null && fieldArgs.length != 0) {
				userId = fieldArgs[0];
			}
			bw.write(userId + "\n");
			bw.flush(); // 버퍼를 비워준다.

			// ReceiveThread 실행
			ReceiveThread receive = new ReceiveThread(br);
			receive.start();

			// 서버에서 보낸 메시지 받기
			while (true) {
				String line = scan.nextLine();
				bw.write(line + "\n");
				bw.flush();
				if (".quit".equalsIgnoreCase(line)) {
					System.out.println(".quit가 입력되어서 끝낸다!");
					System.exit(0);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		fieldArgs = args;
		new ClientEx01();
	}

	// 메세지를 받는 쓰레드 선언
	class ReceiveThread extends Thread {
		// 연결된 소켓과의 입력 스트립 객체
		BufferedReader br = null;

		public ReceiveThread(BufferedReader br) {
			this.br = br;
		}

		@Override
		public void run() {
			while (true) {
				try {
					String serverMessage = br.readLine();
					System.out.println(serverMessage);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						break;
					}
				} catch (SocketException e) {
					System.out.println("클라이언트>> 서버와 연결이 끊어졌습니다.");
					try {
						if(socket != null) socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.exit(0); // 강제 종료
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			} // end of while
		}
	} // end of ReceiveThread
}