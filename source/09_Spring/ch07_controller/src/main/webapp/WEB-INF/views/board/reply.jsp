<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>board의 reply.jsp입니다</h2>
  	<h2>${member.id } / ${member.pw }</h2>
 	<hr>
  	<h2><span onclick="history.back()">[이전페이지로 가기]</span></h2>
	
</body>
</html>