<%@page import="com.lec.dto.CustomerDto"%>
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
		<div class="gnb">
		<%
		if(session.getAttribute("customer")==null){
		%>
			<ul>
				<li><a href="<%=conPath%>/fileboard/fboardList.jsp">고객센터</a></li>
				<li><a href="<%=conPath%>/joinForm.jsp">회원가입</a></li>
				<li><a href="<%=conPath%>/loginForm.jsp">로그인</a></li>
			</ul>
		<%
		}else{
		%>
			<ul>
				<li><a href="#"><%=((CustomerDto)session.getAttribute("customer")).getCname() %></a></li>
				<li><a href="<%=conPath%>/fileboard/fboardList.jsp">고객센터</a></li>
				<li><a href="<%=conPath%>/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath%>/modifyForm.jsp">정보수정</a></li>
			</ul>
		<%
		}
		%>
		</div>
		<div class="logo">
			<img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png">
		</div>
		<div class="lnb">
			<ul>
				<%
				if(session.getAttribute("customer")!=null){
				%>
					<li><a href="<%=conPath%>/book/bookList.jsp">도서보기</a></li>
				<%
				}
				%>
				<li><a href="<%=conPath%>/book/bookRegister.jsp">도서등록</a></li>
			</ul>
		</div>
	</header>
</body>
</html>