<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div id="nav">
		<%
		String name=(String)session.getAttribute("name");
		%>
		<%
		if(name==null){
		%>
			<ul>
				<li><a href="<%=conPath %>/서버프로그램평가/customer/join.jsp">회원가입</a></li>
				<li><a href="<%=conPath %>/서버프로그램평가/customer/login.jsp">로그인</a></li>
				<li><a href="<%=conPath %>/서버프로그램평가/customer/main.jsp">홈</a></li>
			</ul>
		<%	
		}else{
		%>
			<ul>
				<li><a href="<%=conPath %>/서버프로그램평가/customer/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath %>/서버프로그램평가/customer/modify.jsp">정보수정</a></li>
				<li><a href="#"><%=name %>님</a></li>
			</ul>
		<%	
		}
		%>
		</div>
	</header>
</body>
</html>