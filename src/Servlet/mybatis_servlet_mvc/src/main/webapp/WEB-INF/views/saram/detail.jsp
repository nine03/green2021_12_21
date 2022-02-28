<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사람 정보 상세 보기</h1>
<p>${saram }</p>
<hr />
<a href="update.do?no=${saram.no }">수정</a>
<a href="delete.do?no=${saram.no }">삭제</a>
<a href="list.do">목록</a>
</body>
</html>