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
<!-- 장바구니 담기 OR 즉시 구매하기 -->
<h1>제품 상세 보기</h1>
<hr />

<%
ProductDto dto = (ProductDto)request.getAttribute("productDto");
%>

<table border ="1" width = "300">
	<tr>
		<th>번호</th>
		<td><%=dto.getNo()%></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=dto.getpName()%></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><%=dto.getPrice()%></td>
	</tr>
	<tr>
		<th>수량</th>
		<td><%=dto.getEa()%></td>
	</tr>
</table>

<ul>
	<li><a href="cart.do?no=<%=dto.getNo()%>">장바구니 담기</a></li>
	<li><a href="product_list.do">목록</a></li>
</ul>
</body>
</html>