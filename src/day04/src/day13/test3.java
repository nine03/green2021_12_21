package day13;

import static java.lang.System.out;

public class test3 {

	public static void main(String[] args) {
		//과제1 : 3행 3열로 구구단 출력 
		//과제2 : 시작단, 종료단 기능과 합체하세요.
		for(int dan = 2; dan <= 9; dan+=3) { // 열 2 ~ 9
			for(int i = 0; i < 3; i++) {  // 가로로 3개만 출력 
				if(dan + i != 10) {  
				out.printf("***%d***\t",dan+i);	
				}
			}
			out.println();
			for(int cnt = 1; cnt <=9; cnt++) { //행 1 ~ 9
				for(int i = 0; i < 3; i++) { // 가로로 3개만 출력 
					if(dan + i != 10) {
						out.printf("%dx%d=%d\t",dan+i,cnt,(dan+i)*cnt);
					}
				}
				out.println();
			}
		}
	}
}


