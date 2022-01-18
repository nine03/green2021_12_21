package ex01.socketio.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerEx01 {
	ServerSocket listener = null; // 순서3 
	
	public ServerEx01() { // 순서 2
		Socket socket = null; // 순서 4
		BufferedReader br = null; // 순서 5
		BufferedWriter bw = null; // 순서 6
		Scanner scan = new Scanner(System.in); // 순서 7
		
		try {
			listener =  new ServerSocket(9000); // 순서 8
			System.out.println("서버 >>> 서버 대기중 ..."); // 순서 9
			socket = listener.accept(); // 순서 10
			System.out.println("서버 >>> 클라이언트와 접속이 되었습니다~"); // 순서 10
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 순서 11
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 순서 12
			try {
				// 라인의  \n이다. \n이 없는 데이터는 읽을 수 없다.
				String userId = br.readLine(); // 순서 13   
				System.out.println("서버 >>> " + userId + "님이 접속 하였습니다."); // 순서 14
			} catch (Exception e) {
				System.out.println("읽어 들일 데이터가 없다!");
				e.printStackTrace();
			}
//			while(true) { // 순서 15
//				String line = br.readLine(); // 순서 16
//				System.out.println(">>> " + line); // 순서 17
//				bw.write("Server >>> " + line +"\n"); // 순서 18
//				bw.flush(); // 순서 19
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// 순서 1 
		new ServerEx01();
	}
}
