package yeongjun.test02;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx02 {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다...");
			listener.accept();
			socket = listener.accept();
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine(); // 클라이언트로부터 한행 읽기
				if(inputMessage.equalsIgnoreCase("bye")) { // 대소문자 구분없이 
					System.out.println("클라이언트에서 bye로 연결 종료하였음");
					break; 
				}
				System.out.println("클라이언트: " + inputMessage);
				System.out.println("보내기>>> ");
				String outputMessage = scan.nextLine();
				out.write(outputMessage + "\n");
				out.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scan != null) scan.close();
				if(socket != null) socket.close();
				if(listener != null) listener.close();
			} catch (IOException e) {
				System.out.println("클라이언트와 채팅 중 오류 발생!");
			}
		} 
	}

}
