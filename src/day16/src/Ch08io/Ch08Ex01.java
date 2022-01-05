package Ch08io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ch08Ex01 {
	// 예외가 나오는이유 뭐가 들어갈지 모르니깐 
	public static String getLine() { // throws는 호출한 쪽에서 전가해주는거 
		InputStreamReader isr = new InputStreamReader(System.in); // 문자스트림
		BufferedReader br = new BufferedReader(isr);
		
		try {
			return br.readLine(); // readLin() 자바 파일 내용 한 줄씩 읽어들이기 
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getNum() { // 정수 리턴 
		String s = getLine();
		StringBuffer s2 = new StringBuffer(); 
		for(int i = 0; i< s.length(); i++) {  // charAt()은 String으로 저장된 문자열중에서 
											  // 한글자만 선택해서 char타입으로 변환해준다. 
			char ch = s.charAt(i); // 여기서는 char를 정수처럼 사용할 수 있다.
			if(ch > '0' && ch < '9') { // charAt으로 한글자를 가져온다 0과 9사이에 아스키값 그것만 숫자니깐 
				s2.append(ch); // append 메소드 
							   // 인수로 전달된 값을 문자열로 변환한후, 해당 문자열의 마지막에 추가한다.
			}
		}
		return Integer.parseInt(s2.toString());  // 문제점 문자가 섞이면 오류난다. 
	}
	
	public static void main(String[] args) {
				// 블록안에 있는게 우선이다
				//System.out.print("성명입력 : ");
				//String name = br.readLine();
				//System.out.println(name);
		
				System.out.print("주소 입력: ");
				String addr = getLine();
				System.out.println("나이 입력: ");
				int age = getNum();
				
				System.out.println("입력된 주소는 " + addr);
				System.out.println("입력된 나이는 " + age);
	}

	public static void main01(String[] args) {
		Scanner scan = new Scanner("우리나라 true 대한민국\n 만세 false 나라\n 사랑 가족 사랑");
		
		while(scan.hasNext()) {
			if(scan.hasNextBoolean())
				System.out.println(scan.nextBoolean());
			else scan.next();
			
		}

	}

}
