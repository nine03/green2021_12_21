package org.comstudy21.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
	public abstract String action(HttpServletRequest req, HttpServletResponse resp);
}
