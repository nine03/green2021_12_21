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
	String user = (String)session.getAttribute("user");
	out.println(String.format("%s님이 로그인 하셨습니다!", user));
	out.println("<a href=\"member/logout.do\">로그아웃</a>");
}
%>

</body>
</html>