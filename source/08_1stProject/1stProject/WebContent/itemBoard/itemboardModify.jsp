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
<link href="${conPath }/css/write.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<article class="write">
		<section>
		<form action="${conPath }/itemboradModify.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="iId" value="${itemboard.iId }"> 
			<input type="hidden" name="dbFilename" value="${itemboard.iFilename }">
			<div class="title">
				<h2>ITEM Q&A 수정</h2>
			</div>
			<table>
				<tr class="pic">
					<td>이미지</td>
				</tr>
				<tr>
					<td><input type="text" name="iTitle" class="title" value="${itemboard.iTitle }" required="required" size="30"></td>
				</tr>
				<tr>
					<td><textarea name="iContent" rows="5" cols="32">${itemboard.iContent }</textarea></td>
				</tr>
				<tr>
					<td>
						<c:if test="${not empty itemboard.iFilename }">
							원첨부파일 : <a>${itemboard.iFilename}</a>
						</c:if> 
						<c:if test="${empty itemboard.iFilename }">
						 	원첨부파일 : 첨부파일없음
						</c:if>
					</td>
				</tr>
				<tr class="write">
					<td colspan="2">
						<input type="submit" value="수정" class="btn">
						<input type="reset" value="이전" class="btn" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</section>
	</article>
	<jsp:include page="../main/footer.jsp" />

</body>
</html>