<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	int age = Integer.parseInt(request.getParameter("age"));
	if(age >= 19){
		response.sendRedirect("ex4_pass.jsp?age="+age);	// age값 가지고 "url"로 이동 
	}else{
		response.sendRedirect("ex4_ng.jsp?age="+age);
	}
	%>
</body>
</html>