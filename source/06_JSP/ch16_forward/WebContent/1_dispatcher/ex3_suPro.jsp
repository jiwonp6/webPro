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
	<%
	int su = Integer.parseInt(request.getParameter("su"));
	int sum = 0;	//누적변수
	for(int i=1; i<=su; i++){
		sum += i;
	}
	%>
	<h2>1부터 ${param.su }까지 누적합은 <%=sum %>입니다</h2>
</body>
</html>