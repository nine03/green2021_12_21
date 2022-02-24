package org.comstudy21.myapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	// doGet과 doPost를 분기해줘야하는데 그럴때 process를 만들어준다.
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 문자 타입과 응답 문자 타입이 일치해야 안깨짐.
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex = ctxPath.length();
		//  /servlet_jsp_01/home.do에서 '.'이 있는위치가 마지막 인덱스
		int endIndex = reqUri.lastIndexOf(".");
		String path = reqUri.substring(beginIndex, endIndex);
		System.out.println("path -> "+ path);
		endIndex = path.lastIndexOf("/");
		String dirPath = endIndex== 0 ?"/home": path.substring(0, path.lastIndexOf("/"));
		System.out.println("dirPath -> "+ dirPath);
		// dirPath를 읽어서 읽어올 jsp파일의 폴더 이름을 알아냄으로 같은이름의 jsp파일이지만
		// 다른 폴더에 있는경우(ex. member아래 list, bbs아래 list 등..)를 구분할 수 있게된다.
		
		String viewName = "/WEB-INF/views/";
		// 여기를 Map에 추가해서 쓸 수 있다.
		if("/home".equals(path)) {
			viewName += "home.jsp";
		}else if("/member/list".equals(path)) {
			viewName += "member/list.jsp";
		}else if("/board/list".equals(path)) {
			viewName += "bbs/list.jsp";
		}		
		
		
		//System.out.println("process - DispatcherServlet");
		// req.getMethod()을 사용함으로 doGet인지 doPost인지 구분 가능
		//System.out.println("METHOD: "+ req.getMethod());
		//System.out.println("ctxPath : "+req.getContextPath());
		//System.out.println("컨텐트형식 : "+resp.getContentType());
		// req.getRequestURI()에서 substring을 활용해서 필요한 경로만 뽑아내도록 한다.
		//System.out.println("reqUri : "+req.getRequestURI());
		
		// path라고하는것이 forward되는 페이지에서 확인할 수 있다.
		req.setAttribute("path", path);
		
		// forward하기
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
		
	}
	// link나 url로 들어가는 방식은 doGet 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy - DispatcherServlet");
	}
	
	// init은 한번만 호출됨.
	// init이 호출된다면 다른 브라우저로 실행된다는 뜻.
	@Override
	public void init() throws ServletException {
		System.out.println("init - DispatcherServlet");
	}

}