package day13;

import static java.lang.System.out;

import java.util.Scanner;

public class Ch03Ex04 {

	public static void main00(String[] args) {
		//구구단 출력 프로그램
		// 2단 ~ 9단까지 출력하는 프로그램 구현.
		// 밑에서 옆으로 출력  3행 3열로 시작한 단을 입력  종료하는 단을 입력 
		// 목표 
		//int dan = 2;  // 2단  cnt = cnt + 1
		
		for(int dan =2; dan <= 9; dan += 1) {
			out.printf("***%d***\n",dan);
		for(int cnt = 1; cnt <= 9; cnt += 1) { // 1부터~9까지   
			
			out.printf("%d * %d = %d\n",dan,cnt,dan *cnt);
			}
		}
			
	} 
	// 단이 우선 출력  단이랑 카운트랑 바꿔야함
	
	public static void main01(String[] args) {
		for(int title = 2; title<=9; title++) { // 2중 for문 실행 전에 제목이 한줄로 출력 되도록 한다. 
			 out.printf("***%d***\t",title);
		 }
		out.println();
		 for(int cnt = 1; cnt <= 9; cnt += 1) { // 1부터~9까지   
			for(int dan =2; dan <= 9; dan += 1) {
				out.printf("%d*%d=%d\t",dan,cnt,dan*cnt); //\t는 tap옆으로 나옴 
				}
				out.println();
			}
		}
	
	static Scanner scan = new Scanner(System.in);
	
	static int getDan(String message) {
		out.printf(message);
		int dan = scan.nextInt();
		// 유효성 검사
		while(dan < 2 || dan > 9) {
			out.println("입력범위를 초과했습니다!");
			out.print(message);
			dan = scan.nextInt();
		}
		return dan;
	}
	
	
	public static void main02(String[] args) {
		int startDan = 2;
		int endDan = 9;
		
		// 시작단이 종료단 보다 큰 숫자여도 정상 출력 되도록 완성하시오.
		// 값을 치환을 시켜줌 값을 서로 바꿔준다.
		startDan = getDan("시작단 입력>>");
		endDan = getDan("종료단 입력>>");
		
		//치환하기 
		if(startDan > endDan) {
			int temp = startDan;
			startDan = endDan;
			endDan = temp;
		}
		
		for(int dan = startDan; dan <= endDan; dan++) {
			out.printf("***%d***\n",dan);
			for(int cnt = 1; cnt <= 9; cnt += 1) {
				out.printf("%d*%d=%d\n",dan,cnt,dan*cnt); //\t는 tap옆으로 나옴 
				}
			
		}
	}
	public static void main(String[] args) {
		//과제1 : 3행 3열로 구구단 출력 
		//과제2 : 시작단, 종료단 기능과 합체하세요.
		int startDan = 2;
		int endDan = 9;
		
		// 시작단이 종료단 보다 큰 숫자여도 정상 출력 되도록 완성하시오.
		// 값을 치환을 시켜줌 값을 서로 바꿔준다.
		startDan = getDan("시작단 입력>>");
		endDan = getDan("종료단 입력>>");
		
		if(startDan > endDan) {
			int temp = startDan;
			startDan = endDan;
			endDan = temp;
		}
		
		for(int dan = startDan; dan <= endDan; dan += 3) {
			for(int i = 0; i < 3 && dan+i<=endDan; i++) {  // 제목을 찍는부분 
				if(dan+i <= endDan)  //7은같은데 팔은 같은게 아니다 
				out.printf("***%d***\t",dan+i);	
			}
			System.out.println();
			for(int cnt=1;cnt<=9;cnt++) {//구구단을 넣는부분 
				for(int i = 0; i < 3 && dan+i<=endDan; i++) {  // 제목을 찍는부분 
					if(dan+i <= endDan)
					out.printf("%d*%d=%d\t",dan+i,cnt,(dan+i)*cnt);	
				}
				System.out.println();
			}
		}
	}
}

// ---- 코딩 못하는자의 특징 ----
// 1. 빨간 글자를 일기 싫어한다.
// 2. 테스트를 하지 않는다.
// 3. 생각을 안하고 습관적으로 코딩한다.
// 4. 영타가 느리다.
// 5. 선생님을 이유없이 싫어한다.

// 子曰 : "学而不思则罔 xué ér bù sī zé wăng" , "思而不学则殆 sī ér bù xué zé dài " 
// 자왈 "학이불사즉망, 사이불학즉태."