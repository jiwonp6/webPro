<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- age.html -> age.jsp -> pass.jsp -->
	<%
	int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h2><%=age %>살 성인은 주류 구매 가능합니다</h2>
	<button onclick="history.go(-1);">뒤로가기</button>
</body>
</html>