package org.comstudy21.myapp.controller;

import java.util.HashMap;

public class HandlerMapping {
	HashMap<String, Controller> mappings = new HashMap<String, Controller>();
	public HandlerMapping() {
		mappings.put("/home", new HomeController());
		mappings.put("/board/list", new BoardController());
		mappings.put("/member/list", new MemberController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
