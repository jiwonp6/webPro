<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<a href="xx.jsp">xx</a>
	<%--
	//1.
	BoardDao bDao = BoardDao.getInstance();
	out.println("<h2>1. DB 글갯수 : "+bDao.getBoardTotalCnt()+"입니다</h2>");
	//2.
	out.println("<h2>2. 글목록</h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(BoardDto dto : dtos){
		out.println(dto + "<br>");
	}
	//3.
	out.println("<h2>3. 원글쓰기</h2>");
		//BoardDto(int num, String writer, String subject, String content, String email, int readcount, String pw,
			//int ref, int re_step, int re_indent, String ip, Timestamp rdate)
	BoardDto dto = new BoardDto(0, "박길동", "글제목\n", "본문\n", "park@park.com", 0, "1", 0, 0, 0, "127.0.0.2", null);
	int result = bDao.insertBoard(dto);
	out.println(result == BoardDao.SUCCESS ? "글쓰기 성공" : "글쓰기 실패");
	//4. + 5.
	out.println("<h2>4. 글번호로 dto 가져오기 + 5. 조회수 올리기</h2>");
	bDao.readcountUp(1);
	dto = bDao.getboardOneLine(1);
	out.println(dto);
	//6. 
	out.println("<h2>6. 글 수정</h2>");	//dto = bDao.getboardOneLine(1);으로 1번글 들고와서 바꾼 것
	out.println("글 수정 전<br>"+dto);
	dto.setSubject("바뀐제목XXXXX");
	dto.setContent("바뀐본문YYYYY");
	result = bDao.updateBoard(dto);
	if(result == BoardDao.SUCCESS){
		dto = bDao.getboardOneLine(1);
		out.println("<br>글 수정 후<br>"+dto);
	}else{
		out.println("수정실패");
	}
	//7.
	out.println("<h2>7. 글삭제</h2>");
	result = bDao.deleteBoard(2, "110");
	out.println(result==BoardDao.SUCCESS ? "글삭제완료":"글삭제실패");
	--%>
</body>
</html>