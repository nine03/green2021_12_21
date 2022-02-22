<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8 "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	사람 정보 관리 프로그램
</h1>
<P>  The time on the server is ${serverTime}. </P>
<hr />
<ul>
	<li><a href="list.saram">사람 정보 목록</li>
	<li><a href="input.saram">사람 정보 입력</li>
	<li><a href="search.saram">사람 정보 검색</li>
</ul>
</body>
</html>
