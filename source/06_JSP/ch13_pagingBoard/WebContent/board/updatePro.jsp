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
	request.setCharacterEncoding("utf-8"); 
	String pageNum = request.getParameter("pageNum");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<!-- 들어온 파라미터 : subject, content, email, pw, num -->
	<!-- dao의 updateBoard 호출위해 : subject, content, email, pw, num, ip -->
	<%
	dto.setIp(request.getRemoteAddr()); 
	BoardDao dao = BoardDao.getInstance();
	int result = dao.updateBoard(dto);
	if(result == BoardDao.SUCCESS){
	%>
		<script>
			alert('글 수정 성공');
			location.href = 'content.jsp?num=<%=dto.getNum() %>&pageNum=<%=pageNum %>';
		</script>
	<%		
	}else{
	%>
		<script>
			alert('글 수정 실패');
			location.href = 'content.jsp?num=<%=dto.getNum() %>&pageNum=<%=pageNum %>';
		</script>
	<%		
		
	}
	%>
	
</body>
</html>