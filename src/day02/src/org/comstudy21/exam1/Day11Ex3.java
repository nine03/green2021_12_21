package org.comstudy21.exam1;

import java.util.Scanner;

public class Day11Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("정수를 입력하시오 >>");
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
