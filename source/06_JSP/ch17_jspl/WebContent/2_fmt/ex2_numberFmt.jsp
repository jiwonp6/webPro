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
	<c:set var="num" value="1234567.8"/>
	<p>
		num : ${num }
	</p>
	<p>
		세자리 마다 , : <fmt:formatNumber value="${num }" groupingUsed="true"/> 	<!-- 세자리 마다 콤마  -->
	</p>	
	<p>
		세자리 마다 , : <fmt:formatNumber value="${num }" pattern="#,###.#"/> 	<!-- 소수점도 유지되어서 groupingUsed="true"을 더 많이 씀 -->
	</p>
	<p>
		소수점 2자리 (소수점 한자리의 경우 뒤에 0) : <fmt:formatNumber value="${num }" pattern="#,###.00"/>	<!-- 소수점 두자리로 고정 -->
	</p>
	<p>
		소수점 2자리(소수점 한자리의 경우 한자리) : <fmt:formatNumber value="${num }" pattern="#,###.##"/>
	</p>
</body>
</html>