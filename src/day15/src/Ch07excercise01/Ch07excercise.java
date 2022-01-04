package Ch07excercise01;

import java.util.Scanner;
import java.util.Vector;

public class Ch07excercise {
	public Ch07excercise() {
		ex01();
	}
	private void ex01() {
		// 벡터에 저장하고 가장 큰수를 출력 
		// 정수(-1이 입력될때까지) >>
		// 가장 큰수는 
		Vector<Integer> iv = new Vector<Integer>();
		Scanner scan = new Scanner(System.in);
		int i = 0;
		int max = 0;
		System.out.println("정수(-1이 입력될 떄까지)>>");
		while((i = scan.nextInt()) != -1) { // 문자들어오면 오류 날수가 있다 
			if(max < i) { // 비교 
				max = i; // 치환 
			}
			iv.add(i);
			
		}
		System.out.println(iv);
		System.out.println("가장 큰 수는 " + max);
	}
	public static void main(String[] args) {
		new Ch07excercise();
	}
}
