<%@page import="com.lec.dao.FileboardDao"%>
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
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	int fpw = Integer.parseInt(request.getParameter("fpw"));
	String pageNum = request.getParameter("pageNum");
	FileboardDao dao = FileboardDao.getInstance();
	int result = dao.deleteBoard(fnum, fpw);
	if(result == FileboardDao.SUCCESS){
	%>
		<script>
			alert('글 삭제 성공');
			location.href = 'fboardList.jsp?pageNum=<%=pageNum %>';
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