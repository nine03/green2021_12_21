package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex12x2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		out.print("연산>>"); 
		int op1 = sc.nextInt(); 
		String op = sc.next(); 
		int op2 = sc.nextInt(); 
		int res = 0; 
		switch(op) 
		{ 
		case "+": 
			res = op1 + op2; 
			break; 
			case "-": 
				res = op1 * op2; 
				case "*": 
					res = op1 * op2; 
					case "/": 
						if(op2 == 0) 
						{ 
							out.print("0으로 나눌수없다"); 
							sc.close(); 
							}
							res = op1 / op2; 
							break; 
							default: 
								out.print("사칙연산이아닙니다."); 
								sc.close(); 
								break; 
								} 
		out.print(op1 + op + op2 + "의 계산결과는" + res); 
		sc.close();

	}

}
