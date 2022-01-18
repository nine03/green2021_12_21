package ex01.socketio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx01 {
	ServerSocket listener = null; // listener port 를 열어주는 역활 
	
	
	public ServerEx01() {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		Scanner scan = new Scanner(System.in);
		// ServerSocket을 생성하고 클라이언트 접속 대기 
		try {
			// ServerSocket을 생성하고 
			listener =  new ServerSocket(9999); // port 넣어준다 
			System.out.println("서버 >>> 서버 대기중 ...");
			// 클라이언트 접속 대기 - 접속이되면 Socket을 반환한다.
			socket = listener.accept();
			System.out.println("서버 >>> 클라이언트와 접속이 되었습니다~");
			// 클라이언트와 입/출력 스트림을 연결한다.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 클라이언트의 userId를 읽어오기 
			String userId = br.readLine();
			System.out.println("서버 >>> "+ userId + "님이 접속 하였습니다!");
			
			while(true) {
				// 반복해서 읽어들인다.
				String line = br.readLine();
				System.out.println(">>> " + line);
				// 클라이언트로 다시 전송(에코)
				bw.write("Server>>> "+ line + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		// Socket Server
		new ServerEx01();
	}

}
