package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("원의 중심과 반지름 입력>>"); 
		Scanner sc = new Scanner(System.in); 
		double p1 = sc.nextDouble(); 
		double p2 = sc.nextDouble(); 
		double r = sc.nextDouble(); 
		out.println("점 입력>>"); 
		double x = sc.nextDouble(); 
		double y = sc.nextDouble(); 
		double distance = Math.sqrt((x - p1) * (x - p1) + (y - p2) * (y - p2)); 
		if(distance < r) 
			out.println("점 " + "(" + x + " , " + y + ")" + "는 " + "원 안에 있습니다."); 
			else 
				out.println("점 "+ "(" + x + " , " + y + ")" + "는 " + "원 밖에 있습니다."); 
		sc.close();
	}

}
