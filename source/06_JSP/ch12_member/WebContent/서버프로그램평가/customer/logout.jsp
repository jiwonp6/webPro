<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/logout.css" rel="stylesheet">
</head>
<body>
	<%
	session.invalidate();
	%>
	<jsp:include page="header.jsp"/>
	<script>
		location.href="main.jsp";
	</script>
	<jsp:include page="footer.jsp"/>
</body>
</html>