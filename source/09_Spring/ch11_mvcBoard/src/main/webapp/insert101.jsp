<%@page import="com.lec.ch11.dto.BoardDto"%>
<%@page import="com.lec.ch11.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<%
	BoardDao boardDao = BoardDao.getInstance();
	BoardDto bDto = new BoardDto();
	for(int i=0; i<101; i++){
		bDto.setbName("박박박"+i);
		bDto.setbTitle("제목은 "+i);
		bDto.setbContent("본문");
		bDto.setbIp("127.12.10."+i);
		int result = boardDao.write(bDto);
		System.out.println(i+"번째"+(result==1?"성공":"실패"));
	}
	%>