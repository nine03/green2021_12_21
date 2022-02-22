<%@page import="org.comstudy21.myapp.saram.SaramDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사람 정보 목록</h1>
<table width="550" border="1">
   <tr>
      <th>번호</th>
      <th>아이디</th>
      <th>성명</th>
      <th>이메일</th>
   </tr>
<%
ArrayList<SaramDto> saramList = (ArrayList<SaramDto>)request.getAttribute("saramList");
for(int i=0; i<saramList.size(); i++) {
   SaramDto saram = saramList.get(i);
%>
   <tr>
      <td><%=i %></td>
      <td><%=saram.getId() %></td>
      <td><%=saram.getName() %></td>
      <td><%=saram.getEmail() %></td>
   </tr>
<%
} // end of for
%>
</table>
<hr />
<a href="<%=request.getContextPath() %>">Home으로</a> |
<a href="<%=request.getContextPath() %>/input.saram">사람정보입력</a> 
</body>
</html>