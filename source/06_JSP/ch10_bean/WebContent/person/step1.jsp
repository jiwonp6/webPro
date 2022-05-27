<%@page import="com.lec.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%
	Person p = new Person();
	p.setName(request.getParameter("name"));
	p.setAge(Integer.parseInt(request.getParameter("age")));
	p.setGender(request.getParameter("gender").charAt(0));	//char형이라 뒤에 charAt(index)필요함
	p.setAddress(request.getParameter("address"));
	%>
	<h2>입력받은 개인정보</h2>
	<p>이름 <%=p.getName() %></p>
	<p>나이 <%=p.getAge() %></p>
	<p>성별 <%=p.getGender() %></p>
	<p>주소 <%=p.getAddress() %></p>
</body>
</html>