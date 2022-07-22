<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- requestScope : ${bDto }(원글정보) : 답변글을 저장하기 위해 원글의 bgroup, bstep, bindent 필요
		/ 파라미터 : ${param.pageNum } ${param.bId } -->
	<form action="${conPath }/mvcboard/reply.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bgroup" value="${board.bgroup }">
		<input type="hidden" name="bstep" value="${board.bstep }">
		<input type="hidden" name="bindent" value="${board.bindent }">
		<table>
			<caption>${board.bid }번글의 답글쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" required="required" value="[답]${board.btitle }"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn"> 
					<input type="button" value="목록" onclick="location='${conPath}/mvcboard/boardList.do'" class="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>