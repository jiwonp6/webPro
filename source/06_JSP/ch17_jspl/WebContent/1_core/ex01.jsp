<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>core 라이브러리</h2>
	<c:forEach var="i" begin="1" end="3" step="1">
		<p>${i }번째, 안녕하세요</p>
	</c:forEach>
	<hr>
	<h2>스크립트릿 for문 사용</h2>
	<%
	for(int i=1; i<=3; i++){
		out.println("<p>"+i+"번째, 안녕하세요</p>");
	}
	%>
	<hr>
	<h2>fmt(formatting) 라이브러리</h2>
	<fmt:formatNumber value="3.141592" pattern="#.000"/>	<!-- 소수점 3째자리에서 반올림 -->
	<hr>
	<h2>그 외 라이브러리</h2>
		ID파라미터를 대문자로 : ${fn:toUpperCase(param.id) }
</body>
</html>