<%@page import="com.lec.dto.FileboardDto"%>
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
	//임의로 70개 원글 insert
	FileboardDao dao = FileboardDao.getInstance();
	FileboardDto dto = new FileboardDto();
	for(int i =0; i<70; i++){
		if(i%3==0){
			dto.setCid("aaa");
		}else if(i%3==1){
			dto.setCid("bbb");
		}else{
			dto.setCid("ccc");
		}
		dto.setFsubject("강제추가 제목"+i);
		dto.setFcontent("강제추가 본문"+i);
		if(i%5==0){
			dto.setFfilename("액션태그.docx");
		}else{
			dto.setFfilename(null);
		}
		dto.setFpw("111");
		dto.setFip("192.168.10."+i);
		int result = dao.insertBoard(dto);
		System.out.println(result==FileboardDao.SUCCESS ? i+"번째 글쓰기 성공":i+"번째 글쓰기 실패");
	}
	response.sendRedirect("fboardList.jsp");
	%>
</body>
</html>