package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("�� (x,y)�� ��ǥ�� �Է��Ͻÿ� >>"); 
		Scanner sc = new Scanner(System.in); 
		int x = sc.nextInt(); 
		int y = sc.nextInt(); 
		if((100<=x && x<=200)&&(100<=y && y<=200)) 
			out.println("(" + x + "," + y + ")" + "�簢�� �ȿ� ���� �ֽ��ϴ�."); 
		else
			out.println("(" + x + "," + y + ")" + "�簢�� �ȿ� ���� �����ϴ�."); 
		sc.close();
	}

}
