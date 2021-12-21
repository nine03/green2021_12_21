package day14;

import java.util.Scanner;

public class homework2 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int size = 0;
		while(true) {
			try {
				System.out.print("크기입력(홀수만)>>>");
				size = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력 하세요!");
				sc.next();
				continue;
			}
		}
		
		while(size % 2 == 0 || (size  < 5 || size > 15)) {
			try {
				if(size < 5 || size > 15) {
					System.out.println("5이상 15이하 값만 입력하세요!");
					System.out.print("크기입력(홀수만)>>>");
					size = sc.nextInt();
					continue;
				}
				System.out.println("홀수만 입력 하세요!");
				System.out.println("크기입력(홀수만)>>>");
				size = sc.nextInt();
			}  catch(Exception e) {
				System.out.println("숫자만 입력 하세요!");
				sc.next();
				size = 0;
				continue;
			}
		}
		int end = size / 2+1;
		for(int i = 0; i < size; i++) {
			for(int j =0; j < size; j++) {
				System.out.print(j>= end && j < size - end ? " " : "*");
			}
		System.out.println();
		end = i < size / 2 ?  end - 1 : end + 1;
		}
	}

}
