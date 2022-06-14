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
	<form>
	<p>
		<input type="number" name="i" value="<%=(int)(Math.random()*9)+1%>">
		 *
		<input type="number" name="j" value="<%=(int)(Math.random()*9)+1%>">
		 = 
		<input type="number" name="answer">
	</p>
	<p><input type="submit" value="확인"></p>
	</form>
	<p>${param.i } * ${param.j } = 는 ${ param.answer } ${ param.answer eq ((param.i)*(param.j)) ?  "true 정답" : "false"}</p>
</body>
</html>