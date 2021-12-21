package org.comstudy21.levelup;

import java.util.Scanner;

public class test {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 별출력 프로그램 
		// - 별 또는 공백이 반복한번에 한개씩 출력
		//	*********
		//	**** ****
		//	***   ***
		//	**     **
		//	*       *
		//	**     **
		//	***   ***
		//	**** ****
		//	*********
		
		int size = 0;
		while (true) {
			try {
				System.out.print("크기입력(홀수만)>>> ");
				size = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력 하세요!");
				scan.next();
				continue;
			}
		}
		// 유효성 검사 : 5이상 15이하 값만 허용, 홀수만 입력 받을것.
		while(size%2==0 || (size < 5 || size >15)) {
			try {
				if(size < 5 || size >15){
					System.out.println("5이상 15이하 값만 입력하세요!");
					System.out.print("크기입력(홀수만)>>> ");
					size = scan.nextInt();
					continue;
				}
				System.out.println("홀수만 입력 하세요!");
				System.out.print("크기입력(홀수만)>>> ");
				size = scan.nextInt();
			} catch (Exception e) {
				System.out.println("숫자만 입력 하세요!");
				scan.next();// k\n
				size = 0;
				continue;
			}
		}
		
		int end = size/2 + 1;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(j>=end && j<size-end? " " : "*");
			}
			System.out.println();
			end = i<size/2 ? end-1:end+1;
		}
	}
}
