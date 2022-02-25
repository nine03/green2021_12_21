<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인</h1>
<!--
out or pageContext : 해당 페이지 안에서 데이터 공유.
request : URL 주소가 변경되면 데이터가 초기화 된다.
session : 브라우저가 닫히기 전까지 데이터를 공유. 브라우저 차원에서 각각 다른 데이터.
application : 프로젝트 차원에서 같은 데이터 공유.
-->

<%
if(session.getAttribute("user")==null) {
	out.println("<h3>로그인 하세요!</h3>");
%>
	<form action="login.do" border="1" method="POST">
		<fieldset>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" value="hong" /></td>
					<td rowspan="2"><input type="submit" value="Login" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" value="1234" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
<%
} else {
%>
	<jsp:include page="/inc/logout.jsp"></jsp:include>
	<jsp:include page="/inc/menu.jsp"></jsp:include>
<%
}
%>

</body>
</html>