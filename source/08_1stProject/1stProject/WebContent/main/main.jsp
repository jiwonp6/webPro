<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.main{
			width:100%;
			height:1000px;
		}
	</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="main"><h1>main</h1></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>