<%@page import="org.comstudy21.myapp.saram.SaramDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>프로필 페이지</h1>
<hr />
<p>사용자 : ${user_name }</p>
<!-- 표현식 (expression)-->
<p>사용자 : <%=request.getAttribute("user_name") %></p>
<%
// 스크립트렛 : 자바 문법이 적용된다.
SaramDto saramDto = (SaramDto)request.getAttribute("saram_dto");
%>

<p><%=saramDto %></p>
<table border="1">
   <tr>
      <td>id</td>
      <td><%=saramDto.getId() %></td>
   </tr>
   <tr>
      <td>name</td>
      <td><%=saramDto.getName() %></td>
   </tr>
   <tr>
      <td>email</td>
      <td><%=saramDto.getEmail() %></td>
   </tr>
</table>
</body>

</html>


