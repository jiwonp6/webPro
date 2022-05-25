<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- ex1_forward.jsp?n=1로 요청 (url이 바뀜 즉, request객체를 새로 만듦)-->
	<h2>ex1_forward.jsp 페이지입니다</h2>
	<% //response.sendRedirect("ex2_forward.jsp"); %>
	<%
	// <jsp:forward page="ex2_forward.jsp"></jsp:forward>
	// = <jsp:forward page="ex2_forward.jsp"/>
	%>
	<jsp:forward page="ex2_forward.jsp"/>
</body>
</html>