package Ch08io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ch08Ex02 {
	
	// 객체를 파일에 저장하고 객체로 읽어온다.
	// 자바는 객체지향 언어이므로 객체 저장이 더 효과적이다.
	// 객체 직렬화 - 객체를 저장하고 읽을때 필요한 개념.
	// 만약 객체를 집에 비유한다면 ...
	
	public static void main(String[] args) throws IOException {
		// UTF로 기록하고 
		File file = new File("C:\\Users\\user\\data2.txt"); // 파일을 가져온거
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.print("저장 할 문장을 입력 하세요.");
		String ins = null;
		StringBuffer stringData = new StringBuffer();
		while((ins = br.readLine()) != null) {
			if(ins.equals("그만")) break;
			stringData.append(ins); // 줄바꿈 
			stringData.append("\n");
 		}
		
		// ? 에 물음표  인코딩에 문제가 있다.
		// UTF-8 8 비트 아스키값  UTF-16 16비트  가변 데이터를 많이 먹는다 
		dos.writeUTF(stringData.toString());
		dos.close();
		
		// UTF읽기 호출
		test_dis(null);
	}
	
	public static void test_dis(String[] args) throws IOException {
		// 데이터 인풋스트림 데이터 아웃풋스트림
		// DataInputStream
		// 쓰는걸 먼저 만들어야한다.
		File file = new File("C:\\Users\\user\\data2.txt"); // 파일을 가져온거
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis); // 문자 깨졌을때
		DataInputStream dis = new DataInputStream(bis);
		
		String s = null;
		try {
			s = dis.readUTF(); // UTF로 기록된 데이터를 읽어온다. ex) 한글 다른 언어 
			System.out.println(s);
		} catch (IOException e) {
			System.out.println("UTF 일기 오류 발생");
		} finally { // 한글 깨질때  오류나옴 반복 null 나올때까지 
			//System.out.println(s);
			dis.close();
		}
		
//		String s = null;
//		char ch = 0;
//		while ((ch = dis.readChar()) != -1) {
//			System.out.println(ch);
//		}
		
	}
	
	public static void test09(String[] args) throws IOException {
		//fileReader을 이용해서 한줄로 읽어올수있다.
		File file = new File("C:\\Users\\user\\data2.txt");
		FileReader fr = new FileReader(file);
		
		char[] cbuf = new char[255];
		fr.read(cbuf);
		
		System.out.println(new String(cbuf).trim());
		
		fr.close();
	}
	
	public static void test08(String[] args) throws IOException {
		// filewriter로 쓰면 한줄로 끝난다.
		Scanner scan = new Scanner(System.in);
		File file = new File("C:\\Users\\user\\data2.txt");
		FileWriter fw = new FileWriter(file);
		
		String s = scan.nextLine(); 
		
		fw.write(s);
		
		fw.close();
	}

	public static void test07(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\data2.txt");
		FileWriter fw = new FileWriter(file);
		//BufferedWriter bw = new BufferedWriter(fw);
		//Scanner scan = new Scanner(System.in);

		// 키보드로 데이터를 입력 받아서 fw를 이용해서 data2.txt파일에 기록하기

//		InputStream is = System.in;
//		System.out.println("데이터를 입력 해 보세요. 끝내려면 (Ctrl + z) : ");
//		String data = null;
//		try {
//			while ((data = scan.nextLine()) != null) { // -1이면 EOF일때까지 (Ctrl + Z) 들어온다 버퍼에 쌓인다.
//
//				bw.write(data);
//				System.out.println();
//			}
//		} catch (NoSuchElementException e) {
//			
//		}finally {
//			bw.close(); // 이거 안닫아주면 계속 열려있기때문에 기록이안된다.
//			System.out.println("입력 종료!");
//		}
		
		String s = "Hello World! 안녕하세요."; // filewriter를 이용해서 통제로 읽어올수도있다
		fw.write(s);
		
		fw.close();
	}

	public static void test06(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\data.txt");
		FileReader fr = new FileReader(file); // file전용

		BufferedReader br = new BufferedReader(fr);

		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
	}

	public static void test05(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\user\\data.txt");
		Scanner scan = new Scanner(file);

		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}

	public static void test04(String[] args) throws IOException {
		// File
		// url 사이트 가져오는것 크롤링
		// 로그인도 가능하다
		File file = new File("C:\\Users\\user\\test_myfile.txt");
		if (file.exists()) { // 경로가 파일이 있다 없다
			System.out.println(">>>> 있다!");
			if (file.isDirectory()) {
				String[] fileList = file.list(); // 파일을 읽어올때
				for (String fileName : fileList) {
					System.out.println(fileName);
				}
			} else {
				if (file.delete()) { // 파일을 삭제할때
					System.out.println(">>>> 파일이 삭제됨!");
				}
			}
		} else {
			System.out.println(">>>> 없다!");
			if (file.createNewFile()) { // 예외처리해야한다 경로에 파일이 없을 경우 파일 생성해준다.
				System.out.println("파일이 생성 되었습니다.");
			}
		}
	}

	public static void test03(String[] args) throws IOException {
		// 파일에서 데이터 읽어오기
		// InputStream is = System.in;
		// 파일이 많아지면 db를 쓰는게 좋다.
		File file = new File("C:\\Users\\user\\data.txt"); // 파일 객제를 생성했다고해서 파일 객체가 만들어진거 아님
		FileInputStream is = new FileInputStream(file); // 파일을 읽어온걸 데이터로 출력
		int data = 0;
		while ((data = is.read()) != -1) {
			System.out.write(data);
		}
		is.close();
		System.out.println("파일 읽기 완료!");
	}

	public static void test02(String[] args) throws IOException { // 예외를 또 받을려면 똑같이 예외처리해줘야한다 전가
		// OutputStream os = System.out;
		FileOutputStream os = new FileOutputStream("C:\\Users\\user\\data.txt"); // outputstream 자식 역슬레시가 하나씩 더붙는이유는
																					// 특수문자라서
																					// 만약에 위에처럼하면 출력이 화면에서 보여주는게 아니라
																					// 파일에서 보여준다.
																					// 위에 있는것은 기록

		InputStream is = System.in;

		// int data = is.read(); // byte코드 받는것 c언어에서 아스키코드 a(97), A(65), 0(48),
		// \n(엔터)(13)
		// out.println(data);

		System.out.println("데이터를 입력 해 보세요. 끝내려면 (Ctrl + z) : ");
		int data = 0;
		while ((data = is.read()) != -1) { // -1이면 EOF일때까지 (Ctrl + Z) 들어온다 버퍼에 쌓인다.
			os.write(data);
		}
		os.close(); // 이거 안닫아주면 계속 열려있기때문에 기록이안된다.
		System.out.println("입력 종료!");
	}

	public static void test01(String[] args) throws IOException {
		// System.out // printStream 은 outputStream의 자식이다
		OutputStream os = System.out; // 업캐스팅
		byte[] by = new byte[255];

		System.out.println("문자 입력 <<");
		System.in.read(by);

		String s = new String(by).trim(); // 캐릭터가 바이트보다 커서 괜찮다. trim 짤라준다
		// System.out.println(s);

		os.write(s.getBytes());

		// int b = 0;
		// while((b = System.in.read()) != '\n') {
		// os.print((char)b); // 문자로볼려면 char로 형변환을 시켜줘야한다 .
		// os.
		// }
	}

}
