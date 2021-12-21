package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex12x1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.print("연산>>"); 
		Scanner sc = new Scanner(System.in); 
		int op1 = sc.nextInt(); 
		String op = sc.next(); 
		int op2 = sc.nextInt(); 
		int res = 0; 
		if(op.equals("+")) 
			res = op1 + op2; 
		else if(op.equals("-")) 
			res = op1 - op2; 
		else if(op.equals("*")) 
			res = op1 * op2; 
		else if(op.equals("/")) 
		{ 
			if(op2 == 0) 
			{ 
				out.print("0으로 나눌 수 없습니다."); 
				sc.close(); 
				return; 
				} 
			else res = op1 / op2; 
			} else { 
				out.print("사칙연산이 아닙니다."); 
				sc.close(); 
				return; 
				} 
		out.println(op1 + op + op2+"의 계산결과는 "+res); 
		sc.close();
	}

}
