<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사람 정보 입력</h1>
<form action="input.saram" method="POST">
<table>
   <tr>
      <th>아이디</th>
      <td><input type="text" value="TEST" name="id" /></td>
   </tr>
   <tr>
      <th>성명</th>
      <td><input type="text" value="테스형" name="name" /></td>
   </tr>
   <tr>
      <th>이메일</th>
      <td><input type="text" value="test@green.com" name="email" /></td>
   </tr>
   <tr>
      <th colspan="2">
         <input type="submit" value="입력하기" />
      </th>
   </tr>
</table>
</form>
<hr />
<a href="<%=request.getContextPath() %>">Home으로</a>
</body>
</html>