package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("점 (x,y)의 좌표를 입력하시오 >>"); 
		Scanner sc = new Scanner(System.in); 
		int x = sc.nextInt(); 
		int y = sc.nextInt(); 
		if((100<=x && x<=200)&&(100<=y && y<=200)) 
			out.println("(" + x + "," + y + ")" + "사각형 안에 점이 있습니다."); 
		else
			out.println("(" + x + "," + y + ")" + "사각형 안에 점이 없습니다."); 
		sc.close();
	}

}
