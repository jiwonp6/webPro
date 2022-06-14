<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>변수 선언과 출력</h2>
	<c:set var="varName" value="varValue"/>	<!-- 변수선언 -->
	1. varName : ${varName }
	<br>
	<c:set var="varName" value="abc <varValue>"/>	<!-- <>사용하면 태그로 인식해서 출력X -->
	2. varName : ${varName }	<!-- 변수출력 -->
	<br>
	3. varName : <c:out value="${varName }" escapeXml="true"/>	<!-- escapeXml="true" : 특수문자 인식 -->
	<br>
	<c:remove var="varName"/>	<!-- 변수삭제 -->
	4. varName : ${empty varName ? "삭제O" : "삭제X" }
	<br>
	5. varName : <c:out value="${varName }" default="없어진 변수"/>
	<br>
</body>
</html>