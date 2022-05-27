<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap{
			margin : 0 auto;
			height:500px;
			weight:1000px;
		}
		.main_h{
			text-align: center;
			line-height:400px;
			color: #FFCC00;
		}
	</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		<h1 class="main_h">Main</h1>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>