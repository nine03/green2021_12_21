package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		out.println("���������� �����Դϴ�. ����, ����, �� �߿��� �Է��ϼ���");
		
		out.print("ö�� >> ");
		String y1 = sc.next();
		
		out.print("���� >> ");
		String y2 = sc.next();
		
		int win;
		if(y1.equals(y2))
			win = 0;
		else if(y1.equals("����")) {
			if(y2.equals("��"))
				win = 1;
			else 
				win = 2;
		}
		else if(y1.equals("����")) {
			if(y2.equals("����"))
				win = 1;
			else 
				win = 2;
		}
		else {
			if(y2.equals("����"))
				win = 1;
			else
				win = 2;
		}
		if(win == 1)
			out.print("ö���� �̰���ϴ�.");
		else if(win == 2)
			out.print("���� �̰���ϴ�.");
		else 
			out.print("�����ϴ�.");
		sc.close();
	}

}
