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
	<h2>ex2_View.jsp 파일입니다</h2>
	<h2>회원정보</h2>
	<h3>id : ${member.id }</h3>
	<h3>pw : ${member.pw }</h3>
	<h3>rdate : ${member.rdate }</h3>
	<hr>
	<h3>넘어온 파라미터 id : ${param.id }</h3>
	<h3>넘어온 파라미터 pw : ${param.pw }</h3>
	<button onclick="history.go(-1)">이전</button>
</body>
</html>