<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/bstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div class="m">
	<%
	String fnum = request.getParameter("fnum");
	String pageNum = request.getParameter("pageNum");
	%>
	<table>
		<caption><%=fnum %>번 글 삭제</caption>
		<tr>
			<td>
				<fieldset>
				<legend>삭제를 위한 암호가 일치하여야 합니다</legend>
				<form action="fboardDeletePro.jsp" method="post">
					<input type="hidden" name="fnum" value="<%=fnum %>">
					<input type="hidden" name="pageNum" value="<%=pageNum %>">
					<p>암호<input type="password" name="fpw" required="required" class="btn"></p>
					<p>
						<input type="submit" value="삭제" class="btn">
						<input type="reset" value="삭제취소" class="btn" onclick="history.back()">
					</p>
				</form>
				</fieldset>
			</td>
		</tr>
	</table>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>