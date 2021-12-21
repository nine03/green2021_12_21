package org.comstudy21.homework;

import java.util.Scanner;
 
public class Homework02 {
	
	public static final Scanner scan = new Scanner(System.in);
	
	public static boolean inRect(int x, int y, int rectx1, int rectx2, int recty1, int recty2) {
		if( (x >= rectx1 && x <= recty2) && (y >= recty1 && y <= recty2)) {
			return true;
		}
		return false;
	}
	// 2장 연습문제 8번
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 100, x2 = 200, y1 = 100, y2 = 200;
		System.out.println("점(x1,y1)의 좌표를 입력하시오>>");
		int nx1 = scan.nextInt();
		int ny1 = scan.nextInt();
		System.out.println("점(x2,y2)의 좌표를 입력하시오>>");
		int nx2 = scan.nextInt();
		int ny2 = scan.nextInt();
		//int ny3 = scan.nextInt();
		scan.close();
		
		if(inRect(nx1, ny1,x1,x2,y1,y2) && inRect(nx2,ny2,x1,x2,y1,y2)) {
			System.out.println("충돌 성공!");
		} else {
			System.out.println("충돌 실패!");
		}

}

	// 2장 연습문제 7번 충돌검사 (게임개발할때 무조건해야한다.)
	public static void main00(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 100, x2 = 200, y1 = 100, y2 = 200;
		System.out.println("점(x1,y1)의 좌표를 입력하시오>>");
		int nx1 = scan.nextInt();
		int ny1 = scan.nextInt();
		System.out.println("점(x2,y2)의 좌표를 입력하시오>>");
		int nx2 = scan.nextInt();
		int ny3 = scan.nextInt();
		scan.close();
		
		// x가 x1과 x2사이에 있고 y가 y1과 y2사이에 있는가?
	 //	if((x >= x1 && x <= x2) && (y > y1 && y <= y2)) {
	 //		System.out.println("사각형 안에 있습니다!");
	 //	} else {
		//	System.out.println("사각형 안에 없습니다.");
		//}
	}

}
