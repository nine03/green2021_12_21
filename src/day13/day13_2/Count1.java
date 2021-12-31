package day13_2;
//7 - 1번 문제
import java.util.Scanner;
import java.util.StringTokenizer;

public class Count1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println(">>");
			String s = scan.nextLine();
			
			if(s.equals("그만")) {
				System.out.println("종료합니다...");
				break;
			}
			StringTokenizer sttk = new StringTokenizer(s," ");
			System.out.println("어절 개수는 " + sttk.countTokens());
		}
		scan.close();
	}

}
