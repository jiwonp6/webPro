<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.lec.friend.FriendDao"%>
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
	request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
	FriendDao fDao = FriendDao.getInstance();
	System.out.println(1);
	int result = fDao.joinFriend(dto);
	System.out.println(dto);
	if(result == FriendDao.SUCCESS){
	%>
		<script>
			alert('친구가 성공');
			history.back();
		</script>
	<%
	}else{
	%>
		<script>
			alert('친구가 실패');
			history.back();
		</script>
	<% 
	}
	%>
</body>
</html>