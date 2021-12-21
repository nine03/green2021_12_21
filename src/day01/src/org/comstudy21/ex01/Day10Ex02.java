package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		
		out.print("철수 >> ");
		String y1 = sc.next();
		
		out.print("영희 >> ");
		String y2 = sc.next();
		
		int win;
		if(y1.equals(y2))
			win = 0;
		else if(y1.equals("가위")) {
			if(y2.equals("보"))
				win = 1;
			else 
				win = 2;
		}
		else if(y1.equals("바위")) {
			if(y2.equals("가위"))
				win = 1;
			else 
				win = 2;
		}
		else {
			if(y2.equals("바위"))
				win = 1;
			else
				win = 2;
		}
		if(win == 1)
			out.print("철수가 이겼습니다.");
		else if(win == 2)
			out.print("영희가 이겼습니다.");
		else 
			out.print("비겼습니다.");
		sc.close();
	}

}
