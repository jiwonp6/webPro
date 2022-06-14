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
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 사용자가 로그인 : session.setAttribute("customer") -->
	<!-- 관리자가 로그인 : session.setAttribute("admin") -->
	<%-- session.setAttribute("admin", "test"); --%>
	<header>
	<c:if test="${empty customer && empty admin }">
		<!-- 로그인 전 메뉴 -->
		<ul>
			<li><a href="">로그인</a></li>
			<li><a href="">회원가입</a></li>
			<li><a href="">고객센터</a></li>
		</ul>
	</c:if>
	<c:if test="${not empty customer && empty admin }">
		<!-- 사용자 로그인 후 -->
		<ul>
			<li><a href="">로그아웃</a></li>
			<li><a href="">고객센터</a></li>
			<li><a href="#">${cname }님</a></li>
		</ul>
	</c:if>
	<c:if test="${empty customer && not empty admin }">
		<!-- 관리자 로그인 후 -->
		<ul>
			<li><a href="">로그아웃</a></li>
			<li><a href="">공지사항</a></li>
			<li><a href="#">관리자 ${aname }님</a></li>
		</ul>
	</c:if>
	
	</header>
</body>
</html>