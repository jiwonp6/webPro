<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>studentNg.jsp 페이지입니다</h2>
	<h3>confirm에서 실패된 ID : ${param.id }(param의 id)</h3>
	<h3>confirm에서 실패된 ID : ${id }(model의 id, 날아감)</h3>
</body>
</html>