<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String user = (String)session.getAttribute("user");
out.println(String.format("<h3>%s님이 환영합니다!</h3>", user));
out.println("<a href=\""+request.getContextPath()+"/member/logout.do\">로그아웃</a>");
%>