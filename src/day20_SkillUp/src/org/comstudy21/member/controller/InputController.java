package org.comstudy21.member.controller;

import org.comstudy21.member.view.MemberView;

public class InputController extends Controller {

	@Override
	public MemberView hadlerMapping() {
		// 어떤 처리를 하고 보여줄 화면을 반환.
		return input;
	}

}
