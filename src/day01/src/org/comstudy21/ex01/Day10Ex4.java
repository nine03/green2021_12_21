package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		int a,b,c; 
		out.println("���� 3�� �Է� >>"); 
		a = sc.nextInt(); 
		b = sc.nextInt(); 
		c = sc.nextInt(); 
		if(a<b && b<c) 
		{
			out.print("�߰� ���� "+ b + " �Դϴ�.");
			} if(b<a && a<c) {
				System.out.print("�߰� ���� " + a + " �Դϴ�.");
				} 
		else {
			out.print("�߰� ���� " + c + " �Դϴ�.");
			} 
			sc.close();
	}

}
