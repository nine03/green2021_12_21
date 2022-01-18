package ex02.socketio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx01 {
	ServerSocket listener = null;
	public ServerEx01() {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		Scanner scan = new Scanner(System.in);
		try {
			// ServerSocket을 생성하고 
			listener = new ServerSocket(9000); // 모니터 - URL의 제일 끝단 (End Pointer)
			System.out.println("서버 >>> 서버 대기중 ...");
			// 클라이언트 접속 대기 - 접속이 되면 Socket을 반환한다.
			socket = listener.accept();
			System.out.println("서버 >>> 클라이언트와 접속이 되었습니다~");
			// 클라이언트와 입/출력 스트림을 연결한다.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 클라이언트의 userId를 읽어오기
			try {
				// 라인의 '\n'이다. '\n'이 없는 데이터는 readLine()로 읽을 수 없다.
				String userId = br.readLine(); 
				System.out.println("서버 >>> "+userId+"님이 접속 하였습니다!");
			} catch (Exception e) {
				System.out.println("읽어 들일 데이터가 없다!");
			}
			// 받은 데이터를 다시 돌려 주기 - 에코 기능
			while(true) {
				String line = br.readLine();
				if(".quit".equalsIgnoreCase(line)) {
					System.out.println(".quit가 입력되어서 끝낸다!");
					break;
				}
				System.out.println(">>> " + line);
				pw.printf("Server>>> %s\n", line);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// Socket Server
		new ServerEx01();
	}

}