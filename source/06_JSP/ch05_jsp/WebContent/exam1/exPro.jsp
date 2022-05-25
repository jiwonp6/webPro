<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% 
	int num = (int)(Math.random() * 3.0); 
	if(num==3){
		num=2;
	}
	String n1 = request.getParameter("0");
	String n2 = request.getParameter("1");
	String n3 = request.getParameter("2");
	int n=0;
	if(n1!=null && n2==null && n3==null){
		n = 0;
	}else if(n2!=null && n1==null && n3==null){
		n = 1;
	}else if(n3!=null && n2==null && n1==null){
		n = 2;
	}
	if(n!=num){
		String msg = "Wrong! Try Again!<br>"+(n+1)+"은(는) 아니고 정답은 "+(num+1);
		msg = URLEncoder.encode(msg, "utf-8");
		response.sendRedirect("ex.jsp?msg="+msg);
	}
	%>
	<h3>정답입니다.</h3>
	<h3>동전이 있던 곳은 <%=num+1 %></h3>
	<button onclick="history.go(-1);">다시도전</button>
</body>
</html>