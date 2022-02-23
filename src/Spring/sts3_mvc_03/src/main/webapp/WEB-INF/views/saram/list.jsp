<%@page import="org.comstudy21.myapp.saram.SaramDto"%>
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
<h1>사람 리스트</h1>
<table border="1" width="550">
   <tr>
      <th>번호</th>
      <th>아이디</th>
      <th>성명</th>
      <th>이메일</th>
   </tr>
<%
ArrayList<SaramDto> saramList = (ArrayList<SaramDto>) request.getAttribute("saramList");
for(int i=0; i<saramList.size(); i++) {
   SaramDto saram = saramList.get(i);
%>
   <tr>
      <td><%=saram.getIdx() %></td>
      <td><%=saram.getId() %></td>
      <td><a href="detail.action?idx=<%=saram.getIdx() %>"><%=saram.getName() %></a></td>
      <td><%=saram.getEmail() %></td>
   </tr>
<%
} // 내면아이 치료
%>
</table>
<hr />
<ul>
   <li><a href="<%=request.getContextPath()%>">홈으로</a></li>
   <li><a href="<%=request.getContextPath()%>/saram/input.action">사람등록</a></li>
</ul>
</body>
</html>