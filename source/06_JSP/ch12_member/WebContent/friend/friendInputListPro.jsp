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
	int result = fDao.joinFriend(dto);
	if(result == FriendDao.SUCCESS){
		String name = request.getParameter("name");
	%>
		<script>
			alert('<%=name%> 친구가 성공');
			location.href="friendInputList.jsp"
		</script>
	<%
	}else{
	%>
	<script>
		alert('친구가 실패');
		location.href="friendInputList.jsp"
	</script>
	<% 
	}
	%>
</body>
</html>