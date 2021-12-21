package day13;

import java.util.Scanner;
import static java.lang.System.out;

public class test4 {

	static Scanner sc = new Scanner(System.in);
	
	static int getDan(String message) {
		out.printf(message);
		int dan = sc.nextInt();
		
		// 유효성 검사
		while(dan < 2 || dan > 9) {
			out.println("입력범위를 초과했습니다!");
			out.print(message);
			dan = sc.nextInt();
		}
		return dan;
	}
	
	public static void main(String[] args) {
		//과제1 : 3행 3열로 구구단 출력 
		//과제2 : 시작단, 종료단 기능과 합체하세요
		int startDan = 2;
		int endDan = 9;
		
		startDan = getDan("시작단 입력>>");
		endDan = getDan("종료단 입력>>");
		
		//치환하기
		if(startDan > endDan) {
			int temp = startDan;
			startDan = endDan;
			endDan = temp;
		}
		for(int dan =startDan; dan <= endDan; dan+=3) { // 열 2 ~ 9
			for(int i = 0; i < 3; i++) {  // 가로로 3개만 출력 
				if(dan + i < endDan + 1) {  
				out.printf("***%d***\t",dan+i);	
				}
			}
			out.println();
			for(int cnt = 1; cnt <= 9; cnt++) { //행 1 ~ 9
				for(int i = 0; i < 3; i++) { // 가로로 3개만 출력 
					if(dan + i < endDan + 1) {
						out.printf("%dx%d=%d\t",dan+i,cnt,(dan+i)*cnt);
					}
				}
				out.println();
			}

		}
		
	}

}
