package org.comstudy21.member.view;

import org.comstudy21.member.resource.R;

public abstract class MemberView extends R{  // 멤버뷰가 R을 상속 받아서 r에 있는 리소스 사용가능
	public  void display() { // display 실행 
		boolean isMenu = onCreate();
		
		// System.out.println(">>> 기능 실행 후..."); // 필터
		// 모든 뷰가 공통으로 끝날때 실행
		if(!isMenu) {
			no = MENU;
		}
		System.out.println("----------------------------");
	}
	public abstract boolean onCreate();
}
