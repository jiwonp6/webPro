<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
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
			height : 550px;
			padding-top:50px;
		}
	</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<%
	if(request.getParameter("customer")!=null){	//답변글을 위해 들어왔다면 원글의 정보를 dto에
		response.sendRedirect(conPath+"/customer/loginForm.jsp");
	}
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null){
		pageNum = "1";
	}
	int fnum = 0;	//글번호 0으로 초기화
	FileboardDto dto = new FileboardDto();	//빈 dto 객체(fnum, fref, fre_step, fre_level은 0)
	if(request.getParameter("fnum")!=null){	//답글 쓰러 왔음
		fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao dao = FileboardDao.getInstance();	//dto받아오기 위해 dao생성
		dto = dao.getBoard(fnum);	//원글에 대한 정보 (fref, fre_step, fre_level이 필요)
	}
	%>
	<div id="content_form">
	<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="fnum" value="<%=fnum%>">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="fref" value="<%=dto.getFref()%>">
		<input type="hidden" name="fre_step" value="<%=dto.getFre_step()%>">
		<input type="hidden" name="fre_level" value="<%=dto.getFre_level()%>">
		<table>
			<caption><%=(fnum==0) ? "글쓰기":"답변글쓰기" %></caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="fsubject" required="required" autofocus="autofocus"
						value="<%
								if(dto.getFsubject()!=null){	//답변글
									out.print("[답변] "+dto.getFsubject());
								}
								%>">
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="ffilename"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="5" required="required" name="content"></textarea></td>
			</tr>
			<tr>
				<th>삭제 비밀번호</th>
				<td><input type="password" name="fpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value=<%=(fnum==0) ? "글쓰기":"답변글쓰기" %> class="btn">
					<input type="reset" value="다시쓰기" class="btn">
					<input type="button" value="목록" class="btn" onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>
	</form>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>