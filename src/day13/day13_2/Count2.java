package day13_2;
//7 - 2번 문제
import java.util.Scanner;

public class Count2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println(">>");
			String st = scan.nextLine();
			if(st.equals("그만")) {
				System.out.println("종료합니다...");
				break;
			}
			String words[] = st.split(" ");
			System.out.println("어쩔 개수는 " + words.length);
		}
		scan.close();
	}
}
