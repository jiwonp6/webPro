<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div{
			width: 300px;
			height:40px;
			border:1px soild red;
			margin :0 auto;
		}
		h3{
			border-bottom:1px soild red;
			
		}
		input {
			margin : 12px;
			width:70px;
			height:50px;
			background-color:#B2CCFF;
		}
		#msg{
			margin-top:150px;
			color : red;
		}
	</style>
</head>
<body>
	<form action="exPro.jsp" name="frm">
	<div>
		<h3>동전 던지기</h3>
		<hr>
		<br>
		<input type="submit" name="0" value="1번">
		<input type="submit" name="1" value="2번">
		<input type="submit" name="2" value="3번">
		<br>
		<hr>
	</div>
	</form>
	<div id="msg">
		<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.print(msg);
		}
		%>
	</div>
</body>
</html>