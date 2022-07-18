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
	<h3>현재 총 ${cnt }명</h3>
	<form action="${conPath }/quizInput.do" method="post">
		<p>이름 : <input type="text" name="name" value="${quiz.name }"></p>
		<p>국어 : <input type="number" name="kor" value='<c:if test="${quiz.kor!=0 }">${quiz.kor }</c:if>' placeholder="국어점수"></p>
		<p>영어 : <input type="number" name="eng" value='<c:if test="${quiz.eng!=0 }">${quiz.eng }</c:if>' placeholder="영어점수"></p>
		<p>수학 : <input type="number" name="mat" value='<c:if test="${quiz.mat!=0 }">${quiz.mat }</c:if>' placeholder="수학점수"></p>
		<input type="submit">
	</form>
	<h4>${nameError }</h4>
	<h4>${korError }</h4>
</body>
</html>