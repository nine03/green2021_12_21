package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("���� �߽ɰ� ������ �Է�>>"); 
		Scanner sc = new Scanner(System.in); 
		double p1 = sc.nextDouble(); 
		double p2 = sc.nextDouble(); 
		double r = sc.nextDouble(); 
		out.println("�� �Է�>>"); 
		double x = sc.nextDouble(); 
		double y = sc.nextDouble(); 
		double distance = Math.sqrt((x - p1) * (x - p1) + (y - p2) * (y - p2)); 
		if(distance < r) 
			out.println("�� " + "(" + x + " , " + y + ")" + "�� " + "�� �ȿ� �ֽ��ϴ�."); 
			else 
				out.println("�� "+ "(" + x + " , " + y + ")" + "�� " + "�� �ۿ� �ֽ��ϴ�."); 
		sc.close();
	}

}
