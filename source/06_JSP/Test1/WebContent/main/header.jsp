<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		header,
		.nav,
		section,
		footer{
			margin:0 auto;
			width:95%;
			text-align: center;
		}
		.nav ul{
			margin:0 auto;
			overflow: hidden;
			width:550px;
		}
		.nav ul li{
			margin:0 auto;
			padding:20px;
			float: left;
			list-style: none;
		}
		a{
			text-decoration: none;
		}
	</style>
</head>
<body>
	<header>
		<h2>애플리케이션 배포</h2>
	</header>
	<div class="nav">
		<ul>
			<li><a href="<%=conPath %>/member/joinMember.jsp">회원등록</a></li>
			<li><a href="<%=conPath %>/member/memberList.jsp">회원조회/수정</a></li>
			<li><a href="<%=conPath %>/member/salesList.jsp">매출조회(회원/제품)</a></li>
			<li><a href="<%=conPath %>/main/main.jsp">홈으로</a></li>
		</ul>
	</div>
</body>
</html>