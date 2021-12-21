package day14;

import java.util.Scanner;

public class test3 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size = 0;
		while (true) {
			try {
				System.out.print("크기입력(홀수만) >>> ");
				size = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요!");
				sc.next();
				continue;
			}
		}
		// 유효성 검사 : 5보다 크고 15보다는 작은 값만 허용, 홀수만 입력 받을것
		while((size < 5 || size > 15) || size % 2 == 0) {
			try {
				if(size < 5 || size > 15) {
					System.out.println("5이상 15이하 값을 입력해 주세요!");
					System.out.printf("크기입력(홀수만) >>> ");
					size = sc.nextInt();
					continue;
				}
				System.out.println("홀수만 입력해 주세요!");
				System.out.printf("크기입력(홀수만) >>> ");
				size = sc.nextInt();
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요!");
				sc.next();
				size = 0;
				continue;
			}
		}

		for(int i = 0; i < size; i++) {
			for(int j=0; j < size; j++) {
				System.out.print(i == 0 || i == size - 1 || j == 0 || j == size - 1 ? "*" : i == j ? "*" : " ");	
			}
			System.out.println();
		}	
		System.out.println();
		
		int end = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0) {
					System.out.print("*");
				} else if (i == size - 1){
					System.out.print("*");
				} else {
					System.out.print((j == 0) || (j == size - 1) || (j == size / 2 - end) || (j == size / 2 + end) ? "*" : " ");
				}
			}
			System.out.println();
			end = i < size / 2 ? end + 1 : end - 1;
		}
		System.out.println();
	}
}
