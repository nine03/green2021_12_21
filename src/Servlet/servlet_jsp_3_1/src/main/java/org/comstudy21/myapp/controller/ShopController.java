package org.comstudy21.myapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.comstudy21.myapp.model.ProductDto;

public class ShopController extends HttpServlet {
	private static ArrayList<ProductDto> pList = new ArrayList<ProductDto>();
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
	
	private HttpSession session;
	private ArrayList<ProductDto> cartList;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String path = reqUri.substring(ctxPath.length());
		
		String viewName = "/WEB-INF/views/member/login.jsp";
		if("/shop/cart_list.do".equals(path)) {
			viewName = "/WEB-INF/views/shop/cart_list.jsp";
		} else if("/shop/cart_delete.do".equals(path)) {
			System.out.println("/shop/cart_delete.do".equals(path));
			int pno = Integer.parseInt(req.getParameter("pno")==null?"0":req.getParameter("pno"));
			System.out.println("pno => " + pno);
			session = req.getSession();
			if(session.getAttribute("cartList") == null) {
				cartList = new ArrayList<ProductDto>();
				session.setAttribute("cartList", cartList);
			}
			cartList = (ArrayList<ProductDto>)session.getAttribute("cartList");
			int idx = cartList.indexOf(new ProductDto(pno, "", 0, 0));
			System.out.println("idx => " + idx);
			if(idx != -1) {
				cartList.remove(idx);
			}
			resp.sendRedirect("cart_list.do");
			return;
		}else if("/shop/cart_add.do".equals(path)) {
			int pno = Integer.parseInt(req.getParameter("pno")==null?"0":req.getParameter("pno"));
			int ea = Integer.parseInt(req.getParameter("ea")==null?"0":req.getParameter("ea"));
			// session에 cartList가 준비 되어 있어야 한다. 없다면 생성해서 session에 추가
			session = req.getSession();
			if(session.getAttribute("cartList") == null) {
				cartList = new ArrayList<ProductDto>();
				session.setAttribute("cartList", cartList);
			}
			cartList = (ArrayList<ProductDto>)session.getAttribute("cartList");
			// cartList에 저장 된 상품 검색
			boolean flag = false;
			for(int i=0; i<cartList.size(); i++) {
				if(pno == cartList.get(i).getNo()) {
					int newEa = cartList.get(i).getEa() + ea;
					cartList.get(i).setEa(newEa);
					flag = true;
					break;
				}
			}
			if(!flag) {
				int idx = pList.indexOf(new ProductDto(pno, "", 0, 0));
				ProductDto newProduct = pList.get(idx).clone();
				newProduct.setEa(ea);
				cartList.add(newProduct);
			}
			
			resp.sendRedirect("cart_list.do");
			return; // 새로 고침 후 다음 과정이 실행 안 되도록 한다.
		} else if("/shop/product_list.do".equals(path)) {
			req.setAttribute("pList", pList);
			viewName = "/WEB-INF/views/shop/product_list.jsp";
		} else if("/shop/product_detail.do".equals(path)) {
			int no = Integer.parseInt(req.getParameter("no"));
			int i = pList.indexOf(new ProductDto(no, "", 0, 0));
			req.setAttribute("productDto", pList.get(i));
			viewName = "/WEB-INF/views/shop/product_detail.jsp";
		} else if("/shop/cart_modify.do".equals(path)) {
			int no = Integer.parseInt(req.getParameter("pno"));
			session = req.getSession();
			if(session.getAttribute("cartList") == null) {
				cartList = new ArrayList<ProductDto>();
				session.setAttribute("cartList", cartList);
			}
			cartList = (ArrayList<ProductDto>)session.getAttribute("cartList");
			int i = cartList.indexOf(new ProductDto(no, "", 0, 0));
			req.setAttribute("productDto", cartList.get(i));
			viewName = "/WEB-INF/views/shop/cart_modify.jsp";
		}
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String path = reqUri.substring(ctxPath.length());
		
		if("/shop/car_modify.do".equals(path)) {
			int no = Integer.parseInt(req.getParameter("pno"));
			int ea = Integer.parseInt(req.getParameter("ea"));
			session = req.getSession();
			if(session.getAttribute("cartList") == null) {
				cartList = new ArrayList<ProductDto>();
				session.setAttribute("cartList", cartList);
			}
			cartList = (ArrayList<ProductDto>)session.getAttribute("cartList");
			int i = cartList.indexOf(new ProductDto(no, "", 0, 0));
			ProductDto product = cartList.get(i);
			product.setEa(ea);
			
			resp.sendRedirect("cart_list.do");
		}
	}
}
