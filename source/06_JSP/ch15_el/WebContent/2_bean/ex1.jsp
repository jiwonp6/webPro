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
	<jsp:useBean id="member" class="com.lec.member.MemberDto"/>
	<jsp:setProperty property="*" name="member"/>
	<h2>bean태그 이용한 정보 출력</h2>
	<h3>이름 : <jsp:getProperty property="name" name="member"/> </h3>
	<h3>I D : <jsp:getProperty property="id" name="member"/> </h3>
	<h3>비번 : <jsp:getProperty property="pw" name="member"/> </h3>
	<hr>
	<h2>표현식을 이용한 정보 출력</h2>
	<h3>이름 : <%=member.getName() %></h3>
	<h3>I D : <%=member.getId() %></h3>
	<h3>비번 : <%=member.getPw() %></h3>
	<hr>
	<h2>EL 표기번을 이용한 정보 출력</h2>
	<h3>이름 : ${member.name }</h3>	<!-- member.getName을 member.name으로 표현함 -->
	<h3>I D : ${member.id }</h3>
	<h3>비번 : ${member.pw }</h3>
</body>
</html>