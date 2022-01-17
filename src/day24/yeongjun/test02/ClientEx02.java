package yeongjun.test02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx02 {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			socket = new Socket(InetAddress.getLocalHost(),9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.println("보내기>> ");
				String outputMessage = scan.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n");
					out.flush();
					break;
				}
				out.write(outputMessage+ "\n");
				out.flush();
				
				String inputMessage = in.readLine();
				System.out.println("서버: " + inputMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scan != null) scan.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				System.out.println("서버와 채팅 중 오류 발생!");
			}
		}
	}
}