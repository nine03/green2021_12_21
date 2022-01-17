package broadcast;

import java.net.*;
import java.io.*;

public class ChatClient {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("사용법 : java ChatClient [id] [접속할 서버 ip]");
			System.exit(1);
		}
		Socket sock = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endflag = false;

		try {
			/******************************************************************
			 * 입력받은 ip로 10001번 포트에 접속( args[0] : id, args[1] : 서버 ip)
			 * 1. 서버에 접속하기 위해 Socket 생성하고,
			 * Socket으로부터 InputStream과 OutputStream을 얻어와서
			 * 각각 Buffered와 PrintWriter 형태로 변환시킴
			 ******************************************************************/
			sock = new Socket(args[1], 10001); // ip만 넣어주면된다.
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			/******************************************************************
			 * 2. 키보드로부터 입력받기 위한 BufferedReader를 생성한 후,
			 * 서버로부터 전달된 문자열을 모니터에 출력하는 InputThread 객체를 생성
			 ******************************************************************/
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			// 사용자의 id를 서버로 전송한다
			pw.println(args[0]);
			pw.flush();
			InputThread it = new InputThread(sock, br); // 서버의 메시지 받기 위해 
			it.start();
			/******************************************************************
			 * 3. 키보드로부터 한 줄씩 입력받아 서버에 전송(/quit를 입력받기 전까지)
			 ******************************************************************/
			String line = null;
			while ((line = keyboard.readLine()) != null) {
				pw.println(line);
				pw.flush();
				if (line.equals("/quit")) {
					endflag = true;
					break;
				}
			}
			System.out.println("클라이언트의 접속을 종료합니다.");
		} catch (Exception ex) {
			if (!endflag)
				System.out.println(ex);
		} finally {
			try {
				if (pw != null)
					pw.close();
			} catch (Exception ex) {}
			try {
				if (sock != null)
					sock.close();
			} catch (Exception ex) {}
		}
	}
}

/******************************************************************
 * 4. 서버로부터 전달 받은 문자열을 모니터에 출력하는 InputThread 객체를 생성하여
 * BuffereadReader와 Socket 객체를 인자로 전달 받음
 ******************************************************************/

class InputThread extends Thread {
	private Socket sock = null;
	private BufferedReader br = null;
	public InputThread(Socket sock, BufferedReader br) {
		this.sock = sock;
		this.br = br;
	}

	/******************************************************************
	 * 5. 서버로부터 문자열을 읽어 들여 모니터에 출력함
	 ******************************************************************/
	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception ex) {}
			try {
				if (sock != null) {
					sock.close();
				}
			} catch (Exception ex) {}
		}
	}
}