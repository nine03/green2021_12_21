package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberController extends HttpServlet {
	// 동일한 브라우저의 jsp 페이지에서 공유 되는 session 선언
	protected HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String path = reqUri.substring(ctxPath.length());
		
		String viewName = "/WEB-INF/views/member/login.jsp";
		if("/member/joinus.do".equals(path)) {
			viewName = "/WEB-INF/views/member/joinus.jsp";
		} else if("/member/login.do".equals(path)) {
			// URL에 적용되는것은 모두 GET방식 - login페이지로 forward된다.
			viewName = "/WEB-INF/views/member/login.jsp";
		} else if(session!=null && "/member/logout.do".equals(path)) {
			// 세션의 내용을 제거한다.
			//session.removeAttribute(key);
			session.invalidate(); // 세션의 전체 속성을 강제로 제거한다.(초기화)
			resp.sendRedirect("login.do");
			return;
		}
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String path = reqUri.substring(ctxPath.length());
		
		if("/member/login.do".equals(path)) {
			// id와 password파라미터를 받아서 비교 후 로그인 처리
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			if("hong".equals(id) && "1234".equals(password)) {
				// 세션에 정보를 등록한다.
				session = req.getSession();
				session.setAttribute("user", "hong");
			}
			
			resp.sendRedirect("login.do"); // doGet()으로 갱신된다.
		}
	}
}
