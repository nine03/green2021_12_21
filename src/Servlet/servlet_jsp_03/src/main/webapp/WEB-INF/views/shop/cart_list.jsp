<%@page import="org.comstudy21.myapp.model.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니 목록</h1>
	<hr />

	<%
	if (session.getAttribute("cartList") == null) {
		out.println("<h3>상품을 등록하세요!</h3>");
	} else {
		
	%>

	<table border="1" width="500">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>수량</th>
		</tr>
		<%
		ArrayList<ProductDto> cartList = (ArrayList) session.getAttribute("cartList");
		for (int i = 0; i < cartList.size(); i++) {
			ProductDto dto = cartList.get(i);
		%>
		<tr>
			<td><%=dto.getNo()%></td>
			<td><%=dto.getpName()%></td>
			<td><%=dto.getPrice()*dto.getEa()%></td>
			<td><%=dto.getEa()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>