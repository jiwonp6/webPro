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
	<h2>board의 list.jsp입니다</h2>
	<c:if test="${list.size() eq 0 }">
		<h3>입력된 member가 없습니다</h3>
	</c:if>
	<c:if test="${list.size() != 0 }">
	  	<c:forEach var="member" items="${list }">
		  	<h3>${member.id } / ${member.pw }</h3>
		</c:forEach>		
		<h3>이상 : ${list.size() }명</h3>	
	</c:if>	
	<hr>
	<h2><span onclick="${conPath}/">메인페이지로 가기</span></h2>
</body>
</html>