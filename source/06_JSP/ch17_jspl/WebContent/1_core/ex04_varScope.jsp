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
	<!-- request에 속성 추가한 것과 같다 -->
	<c:set var="code" value="80012" scope="request"/>
	<c:set var="price" value="10000" scope="request"/>
	<c:set var="name" value="온도계" scope="request"/>
	<h2>물품정보(ex04_varScope.jsp 페이지)</h2>
	<h3>코드 : ${code }</h3>
	<h3>가격 : ${price }</h3>
	<h3>이름 : ${name }</h3>
	<jsp:forward page="ex05_varScope.jsp"/>
</body>
</html>