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
	<link href="${conPath}/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="gnb">
		<c:if test="${empty member }">
			<ul>
				<li><a href="#">고객센터</a></li>
				<li><a href="${conPath }/joinView.do">회원가입</a></li>
				<li><a href="${conPath }/loginView.do">로그인</a></li>
			</ul>
		</c:if>
		<c:if test="${not empty member }">
			<ul>
				<li><a href="#">${member.mname }님</a></li>
				<li><a href="${conPath}/mLogout.do">로그아웃</a></li>
				<li><a href="#">고객센터</a></li>
			</ul>
		</c:if>
		<c:if test="${not empty admin }">
			<ul>
				<li><a href="#">관리자님</a></li>
				<li><a href="${conPath}/mLogout.do">관리자모드나가기</a></li>
				<li><a href="#">고객센터</a></li>
			</ul>
		</c:if>
		</div>
		<div class="logo">
			<img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png">
		</div>
		<div class="lnb">
			<ul>
				<c:if test="${not empty member }">
					<li><a href="#">로그인 후</a></li>
					<li><a href="#">로그인 후</a></li>
				</c:if>
				<c:if test="${empty member }">
					<li><a href="#">로그인 전</a></li>
					<li><a href="#">로그인 전</a></li>
				</c:if>
			</ul>
			
			<c:if test="${not empty admin }">
			<ul>
				<li><a href="#">관리자메뉴</a></li>
				<li><a href="#">관리자메뉴</a></li>
			</ul>
		</c:if>
		</div>
	</header>
</body>
</html>