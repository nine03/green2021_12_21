package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		out.println("�ݾ����Է��Ͻÿ�>> ");
		int num=sc.nextInt(); 
		out.println("�������� " + num / 50000 + "��"); 
		num%=50000; 
		out.println("������ " + num / 10000 + "��"); 
		num%=10000; 
		out.println("õ���� " + num / 1000 + "��"); 
		num%=1000; 
		out.println("����� " + num / 100 + "��"); 
		num%=100; 
		out.println("���ʿ� "+ num / 50 + "��"); 
		num%=50; 
		out.println("�ʿ� " + num / 10 +"��"); 
		num%=10; 
		out.println("�Ͽ� " + num / 1 + "��"); 
		sc.close();

	}

}
