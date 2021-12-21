package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("첫 번째 원의 중심과 반지름 입력>>"); 
		Scanner sc = new Scanner(System.in); 
		int x = sc.nextInt(); 
		int x1 = sc.nextInt(); 
		double r = sc.nextDouble(); 
		out.println("두 번째 원의 중심과 반지름 입력>>"); 
		int y = sc.nextInt(); 
		int y1 = sc.nextInt(); 
		double r1 = sc.nextDouble(); 
		double distance = 0; 
		distance = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1)); 
		if (distance <= r + r1) 
			out.println("두 원은 서로 겹친다."); 
		else 
			out.println("두 원은 서로 안겹친다."); 
		sc.close();
	}

}
