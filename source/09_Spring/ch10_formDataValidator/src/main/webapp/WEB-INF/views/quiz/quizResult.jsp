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
	<h3>현재 총 ${cnt }명</h3>
	<p>이름 : ${quiz.name }</p>
	<p>국어 : ${quiz.kor }</p>
	<p>영어 : ${quiz.eng }</p>
	<p>수학 : ${quiz.mat }</p>
	<p>총점 : ${quiz.tot() }</p>
	<p>평균 : ${quiz.avg() }</p>
	<button onclick="history.back()">이전</button>
	<button onclick="location='${conPath}/quizInput.do'">다시</button>
</body>
</html>