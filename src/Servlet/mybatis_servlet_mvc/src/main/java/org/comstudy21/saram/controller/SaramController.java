package org.comstudy21.saram.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

@WebServlet("/saram/*")
public class SaramController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SaramDao saramDao = new SaramDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String ctxPath = request.getContextPath();
		String reqUri = request.getRequestURI();
		String path = reqUri.substring(ctxPath.length());

		String viewName = "/WEB-INF/views/saram/list.jsp";
		if ("/saram/insert.do".equals(path)) {
			String method = request.getMethod();
			if ("POST".equals(method)) {
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				saramDao.insert(new SaramDto(0, id, name, age));
				response.sendRedirect("list.do");
				return;
			}
			viewName = "/WEB-INF/views/saram/insert.jsp";
		} else if ("/saram/update.do".equals(path)) {
			String method = request.getMethod();
			int no = Integer.parseInt(request.getParameter("no"));
			if ("POST".equals(method)) {
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				saramDao.update(new SaramDto(no, id, name, age));
				response.sendRedirect("list.do");
				return;
			}
			SaramDto saram = saramDao.selectOne(no);
			request.setAttribute("saram", saram);
			viewName = "/WEB-INF/views/saram/update.jsp";
		} else if ("/saram/detail.do".equals(path)) {
			int no = Integer.parseInt(request.getParameter("no"));
			SaramDto saram = saramDao.selectOne(no);
			request.setAttribute("saram", saram);
			viewName = "/WEB-INF/views/saram/detail.jsp";
		} else if("/saram/delete.do".equals(path)) {
			int no = Integer.parseInt(request.getParameter("no"));
			saramDao.delete(new SaramDto(no, "", "", 0));
			response.sendRedirect("list.do");
			return;
		}else {
			request.setAttribute("title", "Saram List");
			List<SaramDto> saramList = saramDao.selectAll();
			request.setAttribute("saramList", saramList);
		}
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}
}
