package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex11x1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("���� �Է��ϼ���(1~12)>>"); 
		Scanner m = new Scanner(System.in); 
		int num = m.nextInt(); 
		if (num >= 3 && num <= 5) 
			out.println("��"); 
		else if(num >= 6 && num <= 8) 
			out.println("����"); 
		else if(num >= 9 && num <= 11) 
			out.println("����"); 
		else if(num == 12 || num == 1 || num == 2) 
			out.println("�ܿ�"); 
		else 
			out.println("�߸��� ������ �ƴϰ� �Է�"); 
		m.close();

	}

}
