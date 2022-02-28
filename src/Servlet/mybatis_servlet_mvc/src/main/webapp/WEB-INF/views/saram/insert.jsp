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
<form action="insert.do" method="POST">
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" value="TEST" /></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" value="소크라테스" /></td>
		</tr>
		<tr>
			<th>AGE</th>
			<td><input type="text" name="age" value="12" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="저장" /></td>
		</tr>
	</table>
</form>
</body>
</html>