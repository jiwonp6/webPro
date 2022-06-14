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
	<h2>스크립트릿 if문 사용</h2>
	<%
	if(1+2==3){
		out.println("1+2는 3입니다");
	}else{
		out.println("1+2는 3이 아닙니다");
	}
	%>
	<hr>
	<h2>core태그 if 사용</h2>
	<c:if test="${1+2 eq 3 }">
		<p>1+2는 3입니다</p>
	</c:if>
	<br>
	<c:if test="${1+2 != 3 }" var="result">
		<p>1+2는 3이 아닙니다</p>
	</c:if>
		<p>두번째 if문 조건에 대한 결과는 ${result }입니다</p>
		<p>${result eq true ? "true" : "false" }</p>
</body>
</html>