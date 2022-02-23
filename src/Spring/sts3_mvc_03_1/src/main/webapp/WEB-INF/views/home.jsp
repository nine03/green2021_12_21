<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr />
<ul>
	<li><a href="member/list.action">회원가입</a></li>
	<li><a href="saram/list.action">사람관리</a></li>
</ul>

</body>
</html>
