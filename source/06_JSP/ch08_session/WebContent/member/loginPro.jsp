<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id==null||!id.equals("aaa")||pw==null||!pw.equals("1111")){
		response.sendRedirect("login.jsp?msg=xx");
	}else{
		//id와 pw를 세팅해줌
		session.setAttribute("id", id);
		session.setAttribute("name", "박박박");
		session.setAttribute("pw", pw);
		response.sendRedirect("main.jsp?msg=success");
	}
	%>
</body>
</html>