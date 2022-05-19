<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결과화면</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");	//post방식으로 파라미터 전송시만
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
%>
	<p>아이디는 <%=id%>이고</p>
	<p>패스워드는 <%=pw%>입니다</p>
	<p><%=name%>님 반갑습니다</p>
</body>
</html>