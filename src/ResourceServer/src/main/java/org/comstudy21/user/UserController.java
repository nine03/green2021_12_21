package org.comstudy21.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.comstudy21.user.model.UserDao;
import org.comstudy21.user.model.UserDto;
import org.json.JSONArray;
import org.json.JSONObject;

/*
create table user(
no int not null primary key auto_increment,
name varchar(20),
email varchar(100),
phone varchar(50)
)

insert into user(name, email, phone) values('park','park@kkk.com','010-1234-5678');
insert into user(name, email, phone) values('hong','hong@kkk.com','010-3333-3333');
 */

@WebServlet("/user/*")
public class UserController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html; charset=UTF-8");
      resp.setCharacterEncoding("UTF-8");
      req.setCharacterEncoding("UTF-8");
      
      String reqUri = req.getRequestURI();
      String ctxPath = req.getContextPath() + "/user/";
      //System.out.println("reqUri >>> " + reqUri);
      //System.out.println("ctxPath >>> " + ctxPath);
      int beginIndex = ctxPath.length();
      String endPoint = reqUri.substring(beginIndex);
      
      System.out.println(endPoint);
      
      PrintWriter pw = resp.getWriter();
      if("insert".equals(endPoint)) {
         String email = req.getParameter("email");
         String name = req.getParameter("name");
         String phone = req.getParameter("phone");
         UserDto dto = new UserDto(0, name, email, phone);
         if(name!=null && email!=null) {
            UserDao.insert(dto);
         } else {
            pw.write("내용이 없습니다!");
            System.out.println("내용이 없습니다!");
         }
      } else if("list".equals(endPoint)) {
         pw.write(UserDao.selectAllJSONArr().toString(2));
      }else if("search".equals(endPoint)) {
         
      }else if("update".equals(endPoint)) {
         
      }else if("delete".equals(endPoint)) {
         
      } else {
         pw.write(UserDao.selectAllJSONArr().toString(2));
      }
      pw.close();
   }

   protected void doGet_test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // form에서 서버로 data 전송 위해 server.xml에서 URIEncoding="UTF-8" 추가
      resp.setContentType("text/html; charset=UTF-8");
      resp.setCharacterEncoding("UTF-8");
      req.setCharacterEncoding("UTF-8");
      
      PrintWriter pw = resp.getWriter();
      // JSON 데이터 전송하기
      JSONObject saram01 = new JSONObject();
      saram01.put("no", 1);
      saram01.put("name", "KIM");
      saram01.put("email", "GILDONG@a.com");
      saram01.put("phone", "010-1111-1111");
      JSONObject saram02 = new JSONObject();
      saram02.put("no", 2);
      saram02.put("name", "LEE");
      saram02.put("email", "GILJA@a.com");
      saram02.put("phone", "010-2222-2222");
      JSONArray saramArr = new JSONArray();
      saramArr.put(saram01);
      saramArr.put(saram02);
      
      JSONObject root = new JSONObject();
      root.put("member", saramArr);
      
      System.out.println(root.toString(2));
      pw.write(root.toString(2));
      pw.close();
   }
}