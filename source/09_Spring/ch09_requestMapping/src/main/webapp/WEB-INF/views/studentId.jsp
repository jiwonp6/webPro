<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>studentId 페이지입니다</h2>
	<h4>전송방식 : ${method }방식</h4>
	<h4>아이디 : ${id }</h4>
	<h4>파라미터로 넘어온 아이디 : ${param.id }</h4>
</body>
</html>