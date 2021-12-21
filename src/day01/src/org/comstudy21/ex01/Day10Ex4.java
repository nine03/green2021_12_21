package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		int a,b,c; 
		out.println("정수 3개 입력 >>"); 
		a = sc.nextInt(); 
		b = sc.nextInt(); 
		c = sc.nextInt(); 
		if(a<b && b<c) 
		{
			out.print("중간 값은 "+ b + " 입니다.");
			} if(b<a && a<c) {
				System.out.print("중간 값은 " + a + " 입니다.");
				} 
		else {
			out.print("중간 값은 " + c + " 입니다.");
			} 
			sc.close();
	}

}
