<%@page import="com.lec.dto.CustomerDto"%>
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
<link href="<%=conPath%>/css/bstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<%
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	String pageNum = request.getParameter("pageNum");
	FileboardDao dao = FileboardDao.getInstance();
	dao.hitUp(fnum); //hit up 조회수 올리고 dto받아오기
	FileboardDto dto = dao.getBoard(fnum);
	%>
	<table>
		<caption><%=dto.getFnum()%>번 글 상세보기
		</caption>
		<tr>
			<th>글번호</th>
			<td><%=dto.getFnum()%></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><%=dto.getFsubject()%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=dto.getCname()%> : <%=dto.getCid() %>
			<a href='mailto:<%=dto.getCemail() != null ? dto.getCemail() : ""%>'><%=dto.getCemail() != null ? "("+dto.getCemail()+")" : ""%></a></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<%
					if (dto.getFfilename() == null) {
					out.println("첨부파일 없음");
				} else {
					out.println("<a href='../fileboardUpload/" + dto.getFfilename() + "'>" + dto.getFfilename() + " </a>");
				}
				%>
			</td>
		</tr>
		<tr>
			<th>본문</th>
			<td><pre><%=dto.getFcontent()%></pre></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=dto.getFrdate()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=dto.getFhit()%></td>
		</tr>
		<tr>
			<th>IP</th>
			<td><%=dto.getFip()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<button
					onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">목록</button>
				<%
				String cid = null;
				CustomerDto customer = (CustomerDto)session.getAttribute("customer");
				if(customer!=null){
					cid = customer.getCid();
				}
				if(dto.getCid().equals(cid)){
				%>
					<button
						onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">수정</button>
					<button
						onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">삭제</button>
				<%
				}
				if(customer!=null){
				%>
					<button
						onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">답변</button>
				<%	
				}
				%>
			</td>
		</tr>
	</table>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>