<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 받은 정보를 다시 넘겨받는 친구들 -->
	<jsp:useBean id="s" class="com.lec.ex.Student" scope="request"/>
	<h2>학생정보</h2>
	<p>학번<jsp:getProperty name="s" property="snum"/></p>
	<p>이름<jsp:getProperty name="s" property="name"/></p>
	<p>학년<jsp:getProperty name="s" property="grade"/></p>
	<p>반<jsp:getProperty name="s" property="classes"/></p>
	<p>점수<jsp:getProperty name="s" property="score"/></p>
</body>
</html>