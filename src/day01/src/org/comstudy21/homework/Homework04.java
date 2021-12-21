package org.comstudy21.homework;

import java.util.Scanner;

public class Homework04 {
	public static final Scanner scan = new Scanner(System.in);
	public static final String 가위 = "가위";
	public static final String 바위 = "바위";
	public static final String 보 = "보";
	
			// 가위바위보 게임
			// 함수 이용 
	public static String getUserWord(String user) {
		String var = ""; // 지역변수는 초기화를 해야한다 
		do {
			System.out.println("가위 바위 보중에 입력 하세요!");
			System.out.printf("%s >>" , user);
			var = scan.next();
			System.out.println("var => " + var);
		} while(!(var.equals(가위) || var.equals(바위) || var.equals(보))); // 유효성 체크
		System.out.println("입력 성공!");
		return var;
	} // end of getUserWord

	public static void game(String user1Name, String user2Name ) { // main 컨트롤 + 스프에스바 
		String user1 = getUserWord(user1Name);
		String user2 = getUserWord(user2Name);
		
		if(user1.equals(user2)) {
			System.out.println("비겼습니다!");
			return;
		}
		
		String win = "";
		switch(user1) {
		case 가위 : win = user2.equals(바위) ? user2Name : user1Name; break;
		case 바위 : win = user2.equals(보) ? user2Name : user1Name; break;
		case 보  : win = user2.equals(가위) ? user2Name : user1Name; break;
		}
		System.out.println(win +  "이가 이겼습니다.");
	}
	public static void main(String[] args) {
		if(args == null || args.length == 0) {
			System.out.println("argument가 없습니다!");
			return;
		}
		while(args[0] != null && args[1] != null) {
			game(args[0], args[1]);
			System.out.println("계속 하시겠습니까?(y/n) >>");
			char isLoop = scan.next().charAt(0);  // 반복 할건지? 맨앞에 있는걸 뽑는다
			while(!(isLoop == 'n' || isLoop == 'y'  )) {
				System.out.println("y또는 n만 입력하세요!");
				System.out.println("계속 하시겠습니까?(y/n) >>");
				isLoop = scan.next().charAt(0);
			}
			if(isLoop == 'n') {
				break;
			}
		}
	}
}
