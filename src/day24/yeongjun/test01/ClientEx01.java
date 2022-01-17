package yeongjun.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx01 {

	public static void main(String[] args) {
		// 서버에 데이터를 전송하는 기능
		String str = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("내용 입력 : ");
		str = scan.nextLine();
		
		InetAddress ia = null;
		DatagramPacket packet = null;
		DatagramSocket socket = null;
		
		try {
			ia = InetAddress.getLocalHost();
			packet = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 7777);
			socket = new DatagramSocket();
			socket.send(packet);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
