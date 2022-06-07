<%@page import="com.lec.dao.BoardDao"%>
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
	int num = Integer.parseInt(request.getParameter("num"));
	String pw = request.getParameter("pw");
	String pageNum = request.getParameter("pageNum");
	BoardDao dao = BoardDao.getInstance();
	int result = dao.deleteBoard(num, pw);
	if(result == BoardDao.SUCCESS){
	%>
		<script>
			alert('글 삭제 성공');
			location.href = 'list.jsp?pageNum=<%=pageNum %>';
		</script>
	<%		
	}else{
	%>
		<script>
			alert('글 삭제 실패! 비밀번호를 확인하세요');
			history.back();
		</script>
	<%		
		
	}
	%>
	
</body>
</html>