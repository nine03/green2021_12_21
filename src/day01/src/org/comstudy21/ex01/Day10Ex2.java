package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		out.println("2�ڸ��� ���� �Է�(10 ~ 99)>>");
		int num = sc.nextInt();
		if(num / 10 == num % 10) {
			out.println("Yes! 10���ڸ��� 1�� �ڸ��� �����ϴ�.");
		}else {
			out.println("No! 10�� �ڸ��� 1�� �ڸ��� �ٸ��ϴ�.");
		}
		sc.close();
	}

}
