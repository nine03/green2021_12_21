package org.comstudy21.member.view;

import org.comstudy21.member.resource.R;

public abstract class MemberView extends R{  // 멤버뷰가 R을 상속 받아서 r에 있는 리소스 사용가능
	public  void display() { // display 실행 
		onCreate();
	}
	public abstract void onCreate();
}
