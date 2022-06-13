<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/bstyle.css" rel="stylesheet">
	<style>
		#content_form{
			height: 570px; 
			padding-top:30px;
		}
	</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content_form">
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath%>/fileboard/fboardWriteForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th><th>ip</th><th>작성일</th></tr>
		<%
		//startRow, endRow 계산
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		String pageNum = request.getParameter("pageNum");
		//list.jsp 또는 list.jsp?pageNum=11 또는 list.jsp?pageNum=1
		if(pageNum==null){
			pageNum = "1";	//전달받은 pageNum파라미터가 없으면 1페이지로
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1)*PAGESIZE + 1;
		int endRow = startRow + PAGESIZE -1;
		
		FileboardDao dao = FileboardDao.getInstance();
		int totalCnt = dao.CountBoard();	//등록된 글 개수
		if(totalCnt==0){
			out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
		}else{
			ArrayList<FileboardDto> dtos = dao.listBoard(startRow, endRow);
			for(FileboardDto dto : dtos){
				//글번호, 작성자, 글제목, 메일, 조회수
				out.println("<tr><td>"+dto.getFnum()+"</td><td>"+dto.getCid()+"</td>");
				//글제목 <td class='left'><img src='/ch13_board/img/hot.gif'><a href='/ch13_board/board/content.jsp'>글제목</a></td>
				out.println("<td class='left'>");
				//답변글 들여쓰기 -re.gif 이미지 출력
				if(dto.getFre_level()> 0){
					int width = (dto.getFre_level()-1) * 20;
					//<img src'../img/level.gif' width=width height='10'> 들여쓰기 공간 확보
					//<img src='../img/re.gif'>
					out.println("<img src='../img/level.gif' width='"+width+"' height='10'>");
					out.println("<img src='../img/re.gif' >");
				}
				//조회수가 10초과시 hot.gif 이미지 출력
				if(dto.getFhit() > 10){
					out.println("<img src='"+conPath+"/img/hot.gif'>");
				}	
				//현재 페이지 pageNum으로 파라미터 넘겨줌
				out.println("<a href='"+conPath+"/fileboard/content.jsp?fnum="+dto.getFnum()+"&pageNum="+pageNum+"'>"+dto.getFsubject()+"</a>");
				//파일첨부 시 이미지 추가
				if(dto.getFfilename()!=null){
					out.println("<img src='"+conPath+"/img/fileup.jpg'"+" height='10'></td>");
				}
				//메일, 조회수
				out.println("<td>"+(dto.getCemail() !=null ? dto.getCemail() : "-")
								+"</td><td>"+dto.getFhit()+"</td>");
				//out.println("<td>"+dto.getCemail()==null ? " - ":dto.getCemail()+"</td>");
				out.println("<td>"+dto.getFip()+"</td>");
				out.println("<td>"+dto.getFrdate()+"</td>");
			}
		}
		%>
	</table>
	<div class="paging">
		<p>
		<%
		int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE);	//올림, 페이지 갯수(다음 블록 여부)
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt){
			endPage = pageCnt;
		}
		if(startPage > BLOCKSIZE){	//이전블록이 있는지 여부 <a href='list.jsp?pageNum=11'>이전</a>
			out.println("[<a href='fboardList.jsp?pageNum=" + (startPage-1) +"'>이전</a>] ");
		}
		for(int i=startPage; i<=endPage; i++){
			if(i==currentPage){	//페이지 수만 출력(빨간색 글씨로)
				out.println("<b>"+i+"</b>");
			}else{
				out.println("[<a href='fboardList.jsp?pageNum="+ i +"'>"+ i +"</a>] ");
			}
		}
		if(endPage < pageCnt){	//다음블록이 있는지 여부 <a href='list.jsp?pageNum=10'>다음</a>
			out.println("[<a href='fboardList.jsp?pageNum=" + (endPage+1) +"'>다음</a>] ");
		}
		%>
		</p>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>