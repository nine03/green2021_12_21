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

<h1>사람 정보 목록</h1>
<table border="1" width="500">
<tr>
   <th>아이디</th>
   <th>성명</th>
   <th>이메일</th>
</tr>
<%
ArrayList<SaramDto> saramList = (ArrayList<SaramDto>)request.getAttribute("saram_list");
for(int i=0; i<saramList.size(); i++) {
   SaramDto saram = saramList.get(i);
   System.out.println(saram); // 콘솔에 출력된다.
   // 반복문 사이에 HTML문장이 들어가게 한다.
%>
   <!-- for문 내부에 반복되는 HTML 문장 -->
   <tr>
      <td><%=saram.getId() %></td>
      <td><%=saram.getName() %></td>
      <td><%=saram.getEmail() %></td>
   </tr>
<%
}
%>
</table>
</body>
</html>