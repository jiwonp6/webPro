<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
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
	<%	//ex3_list.boardp.jsp 또는 ex3_list_boardp.jsp?pageNum=1 또는 ex3_list_boardp.jsp?pageNum=5
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum = "1";
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE = 3, BLOCKSIZE=4;
	//페이지당 첫번째줄~끝번째줄 소환
	int startRow = (currentPage-1)*PAGESIZE + 1;
	int endRow = startRow + PAGESIZE -1;
	BookDao bDao = BookDao.getInstance();	//싱글톤객체
	ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
	%>
	<table>
		<caption>책 리스트</caption>
		<tr>
			<th>책id</th><th>책이름</th><th>책대표이미지</th><th>가격</th><th>할인율</th>
		</tr>
		<%
		if(books.size()==0){
			out.println("<tr><td colspan='5'>등록된 책이 없습니다</td></tr>");
		}else{
			for(BookDto book : books){
				out.println("<tr><td>"+book.getBid()+"</td><td>"+book.getBtitle()+"</td>");
				out.println("<td><img src='../bookImg/"+book.getBimage1()+"' width='15'></td>");
				out.println("<td>"+book.getBprice()+"</td><td>"+book.getBdiscount()+"</td></tr>");
			}
		}
		%>
	</table>
	<div class="paging">
	<% 
	//페이지 번호 생성
	int bookTotalCnt = bDao.getBookTotCnt();	//전체 개수
	int pageCnt = (int)Math.ceil((double)(bookTotalCnt)/PAGESIZE);
	int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE + 1;
	int endPage = startPage + BLOCKSIZE -1;
	if(endPage> pageCnt){
		endPage = pageCnt;
	}
	if(startPage > BLOCKSIZE){	//이전블럭 존재O
	%>
		[ <a href="ex3_list_boardp.jsp?pageNum=<%=startPage-1 %>">이전</a> ]
	<%
	}
	for(int i=startPage; i<=endPage; i++){
		if(i==currentPage){
			out.println("[ <b>"+i+"</b> ]");
		}else{
			out.println("[ <a href='ex3_list_boardp.jsp?pageNum="+i+"'>"+i+"</a> ]");
		}
	}
	if(endPage<pageCnt){
	%>
		[ <a href="ex3_list_boardp.jsp?pageNum=<%=endPage+1 %>">다음</a> ]
	<%	
	}
	%>
	</div>
</body>
</html>