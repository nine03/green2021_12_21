package ex01.socketio.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx01 {
	Socket socket; // 순서3
	BufferedReader br; // 순서 4
	BufferedWriter bw; // 순서 5
	Scanner scan = new Scanner(System.in); // 순서 6
	
	
	public ClientEx01() { // 순서 2 
		try {
			socket = new Socket(InetAddress.getLocalHost(),9000); // 순서 7
			System.out.println("클라이언트 >>> 서버와 연결되었습니다."); // 순서 8 
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 순서 9 
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 순서 10
			bw.write("user01" + "\n"); // 순서 11
			bw.flush(); // 순서 12
			
			while(true) { // 순서 13
				String line = scan.nextLine(); // 순서 14
				bw.write(line + "\n"); // 순서 15
				bw.flush(); // 순서 17
				String serverMessage = br.readLine(); // 순서 18
				System.out.println(serverMessage); // 순서 19
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	private void mian() {
		new ClientEx01(); // 순서 1
	}
}
