<%@page import="com.lec.dto.BoardDto"%>
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
	//임의로 70개 원글 insert
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for(int i =0; i<70; i++){
		dto.setWriter("박씨"+i);
		dto.setSubject("제목"+i);
		dto.setContent("본문"+i);
		dto.setEmail("parkSeeEverything"+i+"@park.com");
		dto.setPw("111");
		dto.setIp("192.168.10."+i);
		int result = dao.insertBoard(dto);
		System.out.println(result==BoardDao.SUCCESS ? i+"번째 글쓰기 성공":i+"번째 글쓰기 실패");
	}
	response.sendRedirect("list.jsp");
	%>
</body>
</html>