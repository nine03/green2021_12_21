package org.comstudy21.saram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;
import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/saram/*")
public class SaramController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath() + "/saram"; // 글짜를 빼준다
		// System.out.println("reqUri >>>" + reqUri);
		// System.out.println("ctxPath >>>" + ctxPath);
		int beginIndex = ctxPath.length();
		String endPoint = reqUri.substring(beginIndex);
		System.out.println(endPoint);
		
		PrintWriter pw = resp.getWriter();
		if("/input".equals(endPoint)) {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age") ==null?"0":req.getParameter("age"));
			SaramDto dto = new SaramDto(0,id,name,age);
			if(id!=null&& name!=null) {
				SaramDao.insert(dto);
			}else {
				pw.write("내용이 없습니다!");
				System.out.println("내용이 없습니다!");
			}
			
		}else if("/list".equals(endPoint)) {
			pw.write(SaramDao.selectAllJSONArr().toString(2));
			
		}if("/search".equals(endPoint)) {
			
		}if("/update".equals(endPoint)) {
			
		} if("/delete".equals(endPoint)) {
			
		}else {
			pw.write(SaramDao.selectAllJSONArr().toString(2));
		}
		pw.close();
	}
	
	// @Override
	protected void doGet_test2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.write(SaramDao.selectAllJSONArr().toString(2));
		pw.close();
	} 

	protected void doGet_test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form에서 서버로 data 전송 위해 server.xml에서 URIEncoding="UTF-8" 추가 
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("GET - /saram/*");
		System.out.println("doGet() - SaramController");
		
		PrintWriter pw = resp.getWriter();
		// pw.printf("<html><body>");
		// pw.printf("<h1>%s</h1>","안녕 서블렛");
		// pw.println("</body></html>");
		
		// JSON 데이터 전송하기 
		// 번호, 아이디, 성명, 나이
		JSONObject saram01 = new JSONObject();
		saram01.put("no",1);
		saram01.put("id", "KIM");
		saram01.put("name", "GILDONG");
		saram01.put("age", 28);
		JSONObject saram02 = new JSONObject();
		saram02.put("no",2);
		saram02.put("id", "LEE");
		saram02.put("name", "GILJA");
		saram02.put("age", 24);
		JSONArray saramArr = new JSONArray();
		saramArr.put(saram01);
		saramArr.put(saram02);
		
		System.out.println(saramArr.toString(2));
		pw.write(saramArr.toString(2));
		pw.close();
	}

}
