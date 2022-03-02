<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charst="UTF-8"/>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr />

<table width="550" border="1" cellspacing="0">
	<tr>
		<th width ="10%">글번호</th>
		<th width ="40%">아이디</th>
		<th width ="40%">성명</th>
		<th width ="10%">나이</th>
	</tr>

<c:forEach var ="saram" items="${saramList }">
	<tr align="center">
		<td><c:out value="${saram.no }"></c:out></td>
		<td><c:out value="${saram.id }"></c:out></td>
		<td><c:out value="${saram.name }"></c:out></td>
		<td><c:out value="${saram.age }"></c:out></td>
	</tr>
</c:forEach>
</table>
<a href="saram/insert.do">사람정보 입력</a>
</body>
</html>
