package org.comstudy21.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends Controller {

	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return "member/list";
	}

}
