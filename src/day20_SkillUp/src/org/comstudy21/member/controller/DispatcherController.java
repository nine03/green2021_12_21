package org.comstudy21.member.controller;

import org.comstudy21.member.resource.R;
import org.comstudy21.member.view.MemberView;

public class DispatcherController extends R{
	
	
	
	private static MemberView view = null;
	public static void run() {
		view = new InputController().hadlerMapping(); // 메뉴가 실행하게끔
		
		mainActivity.setContentView(view);
	}
}
