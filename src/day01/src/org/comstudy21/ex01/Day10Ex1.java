package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		out.println("��ȭ�� �Է��ϼ���(���� : ��)>>");
		int num = sc.nextInt();
		double dollar = num / 1100;
		out.println(num + "���� $" + dollar + "�Դϴ�.");
		sc.close();
	}

}
