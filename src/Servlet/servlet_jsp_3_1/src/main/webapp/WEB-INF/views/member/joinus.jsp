<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>

<%
if(session.getAttribute("user")==null) {
	out.println("<h3>로그인 하세요!</h3>");
} else {
%>
	<jsp:include page="/inc/logout.jsp"></jsp:include>
<%
}
%>

</body>
</html>