package Ch07excercise02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Ch07excercise {
	public Ch07excercise() {
		ex04();
	}
	
	private void ex04() { // 4번 문제 
		// Vector에 강수량을 입력하고 평균을 구한다.
		Vector<Integer> v = new Vector<Integer>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("강수량 입력 (0 입력시 종료)>>");
			int num = scan.nextInt();
			if(num == 0) break;
			v.add(num);
			int sum = 0 ; // 총점 
			Iterator<Integer> it = v.iterator();
			while(it.hasNext()) {
				int n = it.next();
				sum += n; // 누적
				System.out.print(n + " ");
			}
			System.out.println("\n현재 평균 " + sum / v.size());
		}
		scan.close();
	}

	 private void ex03() {  // 3번 문제 
	      // 나라 이름과 인구 입력
	      HashMap<String, Integer> nations = new HashMap<String, Integer>();
	      Scanner scan = new Scanner(System.in);
	      System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
	      while(true) { // 반복
	         System.out.print("나라 이름, 인구 >> ");
	         String 나라이름 = scan.next();
	         if("그만".equals(나라이름)) break;
	         int 인구 = scan.nextInt();
	         nations.put(나라이름, 인구); // 저장됨
	      }
	      while(true) { // 인구 검색
	         System.out.print("인구 검색 >> ");
	         String 나라이름 = scan.next();
	         if("그만".equals(나라이름)) break;
	         if(nations.get(나라이름) != null) {
	            int 인구 = nations.get(나라이름); // 객체가 없다면 오토 언박싱 X
	            						      // 오토 언박싱이 일어난다.
	            System.out.println(나라이름+"의 인구는 "+인구);
	         } else {
	            System.out.println(나라이름 + "나라는 없습니다.");
	         }
	      }
	      scan.close();
	   }


	private void ex02() {  // 2번 문제
		Scanner scan = new Scanner(System.in);
		final int MAX = 6;
		// TODO Auto-generated method stub
		ArrayList<Character> scoreList = new ArrayList<Character>();
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		for(int i = 0; i < MAX;) {
			//scoreList.add(scan.next().charAt(0));
			Character ch = 0;
			ch = scan.next().charAt(0);
			if( ch == 'A' || ch == 'B' || ch =='C' || ch == 'D' || ch == 'F') {
			scoreList.add(ch);
			i++;
			}
		}
		scan.close();
		
		Iterator<Character> it = scoreList.iterator();
		double sum = 0;
		while(it.hasNext()) {
			Character score = it.next();
			sum += (69 - score) < 0 ? 0 : (double)(69 - score);
		}
		System.out.println(scoreList);
		System.out.println("평균 = " + sum / MAX);
	}
	
	private void ex01() { // 1번 문제 
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
