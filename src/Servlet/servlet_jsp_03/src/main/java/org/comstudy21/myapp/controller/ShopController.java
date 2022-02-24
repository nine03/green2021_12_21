package org.comstudy21.myapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.comstudy21.myapp.model.ProductDto;

public class ShopController extends HttpServlet {
	private static ArrayList<ProductDto> pList = new ArrayList<>();
	protected HttpSession session;
	protected ArrayList<ProductDto> cartList = new ArrayList<>();

	static {
		pList.add(new ProductDto(ProductDto.nextSeq(), "세탁기", 200, 1));
		pList.add(new ProductDto(ProductDto.nextSeq(), "냉장고", 400, 1));
		pList.add(new ProductDto(ProductDto.nextSeq(), "오디오", 100, 1));
		pList.add(new ProductDto(ProductDto.nextSeq(), "청소기", 50, 1));
		pList.add(new ProductDto(ProductDto.nextSeq(), "비디오", 80, 1));
		pList.add(new ProductDto(ProductDto.nextSeq(), "테레비", 300, 1));
		pList.add(new ProductDto(ProductDto.nextSeq(), "면도기", 20, 1));
		pList.add(new ProductDto(ProductDto.nextSeq(), "인덕션", 200, 1));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String path = reqUri.substring(ctxPath.length());
		String viewName = "/WEB-INF/views/shop/product_list.jsp";
		if ("/shop/cart.do".equals(path)) {
			if(req.getParameter("no") != null) {
				if ("/shop/cart.do".equals(path)) {
					if (session == null) {
						session = req.getSession();
					}
					int no = Integer.parseInt(req.getParameter("no"));
					int i = pList.indexOf(new ProductDto(no, "", 0, 0));
					ProductDto dto = pList.get(i);
					if (cartList.contains(dto)) {
						int index = cartList.indexOf(dto);
						cartList.get(index).setEa(cartList.get(index).getEa() + 1);
					}else {
						cartList.add(dto);
					}
					if (session.getAttribute("cartList") == null) {
						session.setAttribute("cartList", cartList);
					}
				}
			}
			viewName = "/WEB-INF/views/shop/cart_list.jsp";
		} else if ("/shop/product_list.do".equals(path)) {
			req.setAttribute("pList", pList);
			viewName = "/WEB-INF/views/shop/product_list.jsp";
		} else if ("/shop/product_detail.do".equals(path)) {
			int no = Integer.parseInt(req.getParameter("no"));
			int i = pList.indexOf(new ProductDto(no, "", 0, 0));
			req.setAttribute("productDto", pList.get(i));
			viewName = "/WEB-INF/views/shop/product_detail.jsp";
		}

		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}

}