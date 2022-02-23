package org.comstudy21.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@RequestMapping(value="list.action", method = RequestMethod.GET)
	public String memberList(Model model) {
		System.out.println("::: memberList method :::");
		
		return "member/list";
	}
}
