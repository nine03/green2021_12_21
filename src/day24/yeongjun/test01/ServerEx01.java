package yeongjun.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServerEx01 {

	public static void main(String[] args) {
		// 서버에서 클라이언트 요청
		byte[] by = new byte[65535];
		DatagramPacket packet = null;
		DatagramSocket socket = null;
		InetAddress ia = null; // id 저장하는곳 
		
		try {
			ia = InetAddress.getLocalHost();
			// System.out.println("LocalHost : " + ia.toString());
			socket = new DatagramSocket(7777, ia); // 앞에는 포트 뒤에는 ip
			packet = new DatagramPacket(by, by.length);
			System.out.println("서버 준비...");
			socket.receive(packet); 
			packet.setData(by);
			System.out.println(new String(by).trim()); 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // ip를 찾는곳
		catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
