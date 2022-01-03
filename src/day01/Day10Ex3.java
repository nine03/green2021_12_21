package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		out.println("금액을입력하시오>> ");
		int num=sc.nextInt(); 
		out.println("오만원권 " + num / 50000 + "매"); 
		num%=50000; 
		out.println("만원권 " + num / 10000 + "매"); 
		num%=10000; 
		out.println("천원권 " + num / 1000 + "매"); 
		num%=1000; 
		out.println("백원권 " + num / 100 + "매"); 
		num%=100; 
		out.println("오십원 "+ num / 50 + "매"); 
		num%=50; 
		out.println("십원 " + num / 10 +"매"); 
		num%=10; 
		out.println("일원 " + num / 1 + "매"); 
		sc.close();

	}

}
