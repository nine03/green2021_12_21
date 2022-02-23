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
<%
SaramDto saram = (SaramDto)request.getAttribute("saramDto");
%>
	<h1>사람 정보 상세 페이지</h1>
	<table width="550" border="1">
		<tr>
			<th width="20%">고유 번호</th>
			<td width="80%"><%=saram.getIdx() %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=saram.getId() %></td>
		</tr>
		<tr>
			<th>성명</th>
			<td><%=saram.getName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=saram.getEmail() %></td>
		</tr>
	</table>
	<hr />
	<ul>
		<li><a href="list.action">목록</a></li>
		<li><a href="modify.action?idx=<%=saram.getIdx() %>">수정</a></li>
		<li><a href="delete.action?idx=<%=saram.getIdx() %>">삭제</a></li>
	</ul>
</body>
</html>