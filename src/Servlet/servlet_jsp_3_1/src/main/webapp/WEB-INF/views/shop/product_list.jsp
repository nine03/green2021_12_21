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

<h1>상품 목록</h1>

<%
if(session.getAttribute("user")==null) {
	out.println("<h3>회원제입니다! 먼저 로그인 하세요!</h3>");
%>
	<jsp:include page="/inc/menu.jsp"></jsp:include>
<%
} else {
	ArrayList<ProductDto> pList = (ArrayList<ProductDto>)request.getAttribute("pList");
	out.println("<p>상품 갯수 : "+pList.size()+"</p>");
%>
	<jsp:include page="/inc/logout.jsp"></jsp:include>
	<!-- 로그인이 되면 상품 목록이 보여진다. -->
	<table border="1" width="550">
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>가격</th>
			<th>상세보기</th>
		</tr>
	<%
		for(int i=0; i<pList.size(); i++) {
			ProductDto product = pList.get(i);
	%>
		<tr align="center">
			<td><%=product.getNo() %></td>
			<td><%=product.getpName() %></td>
			<td><%=product.getPrice() %></td>
			<td><a href="product_detail.do?no=<%=product.getNo() %>">상세보기</a></td>
		</tr>
	<%
		}
	%>
	</table>
<%
}
%>

</body>
</html>