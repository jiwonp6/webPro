<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<section style="height: 500px;">
		<h1>쇼핑몰 회원관리 프로그램</h1>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>