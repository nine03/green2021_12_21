package org.comstudy21.member.controller;

import static org.comstudy21.member.resource.R.*;
import org.comstudy21.member.view.MemberView;

public class DispatcherController{
	
	private static MemberView view = null;
	private static Controller ctrl = null; // 멤버 필드로 만들기
	
	public static void run() {
		// view = new InputController().hadlerRequest(); // 메뉴가 실행하게끔
		// view = new MenuController().hadlerRequest();
		
		if(no == INPUT) {
			mainActivity.setContentView(input); // view 실행 
			ctrl = ctrlMapper.get(INPUT); 
			view = ctrl.hadlerRequest();
		} else {
			ctrl = ctrlMapper.get(no); 
			view = ctrl.hadlerRequest();
			mainActivity.setContentView(view);
		}
		
		
		
		// no = MENU;
		run(); // 재귀호출
	}
}
