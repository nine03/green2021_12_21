package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		out.println("���� 3���� �Է��Ͻÿ�>>"); 
		int l1 = sc.nextInt(); 
		int l2 = sc.nextInt(); 
		int l3 = sc.nextInt(); 
		if((l1+l2)<l3 || (l1+l3)<l2 || (l2+l3)<l1) 
			out.println("�ﰢ���� ���� �� �����ϴ�."); 
		else out.println("�ﰢ���� �˴ϴ�."); 
		sc.close();

	}

}
