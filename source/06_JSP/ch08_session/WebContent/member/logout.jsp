<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.logout_h1{
			text-align: center;
			line-height:400px;
			color: #FFCC00;
		}
	</style>
</head>
<body>
	<%
	session.invalidate();
	%>
	<jsp:include page="header.jsp"/>
	<h1 class="logout_h1">로그아웃 완료. 5초 후 페이지 이동이 있겠습니다.</h1>
	<script>
		// 5초 후 함수 호출
	    setTimeout(function (){
		    location.href="main.jsp";
		},5000);  
	</script>
	<jsp:include page="footer.jsp"/>
</body>
</html>