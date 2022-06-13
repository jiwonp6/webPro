<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/bstyle.css" rel="stylesheet">
<style>
#content_form {
	height: 550px;
	padding-top: 50px;
}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<%
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String pageNum = request.getParameter("pageNum");
		FileboardDao dao = FileboardDao.getInstance();
		FileboardDto dto = dao.getBoard(fnum);
		System.out.println(dto + "글 수정 들어갑니둥");
		%>
		<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="fnum" value="<%=fnum%>"> 
			<input type="hidden" name="pageNum" value="<%=pageNum%>">
			<input type="hidden" name="dbfilename" value="<%=dto.getFfilename()==null ? "":dto.getFfilename()%>">
			<table>
				<caption><%=fnum%>번 글 수정</caption>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="fsubject"
							value="<%=dto.getFsubject()%>" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="cname"
							value="<%=dto.getCname()%>" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="ffilename" style="width:30%;">
						<%
						if(dto.getFfilename()!=null){
							out.println("( 첨부파일 : "+dto.getFfilename()+" )");
						}else{
							out.println("첨부파일없음");
						}
						%>
					</td>
				</tr>
				<tr>
					<th>본문</th>
					<td>
						<textarea rows="5" cols="5" name="fcontent"
							required="required"><%=dto.getFcontent()%></textarea>
					</td>
				</tr>
				<tr>
					<th>글 삭제 비밀번호</th>
					<td>
						<input type="password" name="fpw" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정" class="btn">
						<input type="reset" value="이전" onclick="history.go(-1)" class="btn"> 
						<input type="button" value="목록" class="btn"
								onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>