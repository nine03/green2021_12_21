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
<%
if(session.getAttribute("user")==null) {
	out.println("<h3>로그인 하세요!</h3>");
%>
	<jsp:include page="/inc/menu.jsp"></jsp:include>
<%
} else {
%>
	<jsp:include page="/inc/logout.jsp"></jsp:include>
	<hr />
	<table border="1" width="550">
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>가격</th>
			<th>수량</th>
			<th>합계</th>
			<th>수정</th>
			<th>제거</th>
		</tr>
	<%
	if(session.getAttribute("cartList") != null) {
		ArrayList<ProductDto> cartList = (ArrayList<ProductDto>)session.getAttribute("cartList");
		for(int i=0; i<cartList.size(); i++) {
			ProductDto product = cartList.get(i);
	%>
		<tr align="center">
			<td><%=product.getNo() %></td>
			<td><%=product.getpName() %></td>
			<td><%=product.getPrice() %>원</td>
			<td><%=product.getEa() %>개</td>
			<td><%=product.getTotalPrice() %>원</td>
			<td><a href="cart_modify.do?pno=<%=product.getNo() %>">수정</a></td>
			<td><a href="cart_delete.do?pno=<%=product.getNo() %>">제거</a></td>
		</tr>
	<%
		}
	%>
	</table>
	<a href="product_list.do">상품목록</a>
<%
	}
}
%>
</body>
</html>