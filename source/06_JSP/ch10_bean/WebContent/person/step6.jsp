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
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty name="p" property="*"/>
	<!-- person.html의 name과 자바빈 PersonInfo의 name이 같으면 *로 불러올 수 있음 -->
	<jsp:forward page="step4_pView.jsp"/>
</body>
</html>