<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="nowDateUtil" value="<%=new java.util.Date() %>"/>
	${nowDate }<br>		<!-- 날짜 -->
	${nowTimes }<br>	<!-- 날짜+시간 -->
	${nowDateUtil }<br>		<!-- 날짜+시간+요일 -->
	
	<hr>
	
	<h3>날짜만 출력</h3>
	nowDate : <fmt:formatDate value="${nowDate }" type="date"/><br>
	nowTimes : <fmt:formatDate value="${nowTimes }" type="date"/><br>
	nowDateUtil : <fmt:formatDate value="${nowDateUtil }" type="date"/><br>
	<br>
	nowDate(short) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/><br>
	nowDate(medium) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/><br>
	
	<hr>
	
	<h3>날짜랑 요일</h3>
	nowDate(long) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/><br>
	nowDate(full) : <fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/><br>
	
	<hr>
	
	<h3>시간만 출력</h3>
	nowDate : <fmt:formatDate value="${nowDate }" type="time"/><br>
	nowTimes : <fmt:formatDate value="${nowTimes }" type="time"/><br>
	nowDateUtil : <fmt:formatDate value="${nowDateUtil }" type="time"/><br>
	<br>
	nowDate(short) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/><br>
	nowDate(medium) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/><br>
	
	<hr>
	
	<h3>시간이랑 요일</h3>
	nowDate(long) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/><br>
	nowDate(full) : <fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/><br>
	
	<hr>
	
	<h3>날짜랑 시간 모두 출력</h3>
	nowDate : <fmt:formatDate value="${nowDate }" type="both"/><br>
	nowTimes : <fmt:formatDate value="${nowTimes }" type="both"/><br>
	nowDateUtil : <fmt:formatDate value="${nowDateUtil }" type="both"/><br>
	<br>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" pattern="yyyy년MM월dd일(E요일) hh:mm:ss:SS(a)"/><br>
	<fmt:formatDate value="${nowDate }" pattern="yy-MM-dd(E) HH:mm:ss:SS"/><br>
</body>
</html>