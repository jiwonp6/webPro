<%@page import="com.lec.dao.Mvc_MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%	//idConfirm.jsp?mid=aaa
	String mid = request.getParameter("mid");
	Mvc_MemberDao dao = Mvc_MemberDao.getInstance();
	int result = dao.IdChk(mid);
	if(result == Mvc_MemberDao.EXISTENT){
		out.print("중복된 ID입니다");
	}else{
		out.print("사용 가능한 ID입니다");
	}
	%>	
</body>
</html>