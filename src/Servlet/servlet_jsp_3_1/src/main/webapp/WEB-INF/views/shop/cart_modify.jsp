<%@page import="org.comstudy21.myapp.model.ProductDto"%>
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
ProductDto product = (ProductDto)request.getAttribute("productDto");
%>
<form action="car_modify.do" method="POST">
	<input type="hidden" value="<%=product.getNo()%>" name="pno"/>
	<table>
		<tr>
			<th>제품번호</th>
			<td><%=product.getNo() %></td>
		</tr>
		<tr>
			<th>제품명</th>
			<td><%=product.getpName() %></td>
		</tr>
		<tr>
			<th>수량</th>
			<td>
				<select id="ea" name="ea">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="변경완료" />
			</th>
		</tr>
	</table>
</form>

</body>
</html>