package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		out.println("2자리의 정수 입력(10 ~ 99)>>");
		int num = sc.nextInt();
		if(num / 10 == num % 10) {
			out.println("Yes! 10의자리와 1의 자리가 같습니다.");
		}else {
			out.println("No! 10의 자리와 1의 자리가 다릅니다.");
		}
		sc.close();
	}

}
