package day14;

import java.util.Scanner;

public class homework1 {

	static Scanner sc = new Scanner(System.in);
	
		static int getSize() {
			
		int size = 0;
		while(true) {
			try {
				System.out.print("크기입력(홀수만)>>>");
				size = sc.nextInt();
				break;
			} catch(Exception e) {
				System.out.print("숫자만 입력하세요!");
				sc.next();
				continue;
			}
		}
		if(size == -1) {
			return size;
		}
	
		// 유효성 검사 : 5이상 15이하 값만 허용, 홀수만 입력 받을것 
		while(size%2==0 &&(size<5 || size > 15)) {
			try {
				if(size < 5|| size > 15) {
					System.out.println("5이상 15이하 값만 입력하세요!");
					System.out.print("크기입력(홀수만)>>>");
					size = sc.nextInt();
					continue;
				}
				System.out.println("홀수만 입력 하세요!");
				System.out.print("크기입력(홀수만)>>>");
				size = sc.nextInt();
			} catch(Exception e) {
				System.out.println("숫자만 입력 하세요!");
				sc.next();
				size = 0;
				continue;
			}
		}
		return size;
	}
		
	static void printStar(int size) {	
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print((i==0)||(i==size-1)||(j==i)||(j==0)||(j==size-1) ? "*":" ");
			}
			System.out.println();
			//end = end / 2+1;
		}
		System.out.println();
		
		int end = size/2 + 1;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(j>=end && j<size-end? " " : "*");
			}
			System.out.println();
			end = i<size/2 ? end-1:end+1;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		while(true) {
			int size = getSize();
			if(size == -1) {
				System.out.println("종료되었습니다.");
				break;
			}
			printStar(size);
			System.out.println("종료하시려면 -1 을 입력하세요.");
		}
	}
}
