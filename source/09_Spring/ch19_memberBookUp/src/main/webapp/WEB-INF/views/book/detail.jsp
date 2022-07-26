<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:500px;
		margin: 50px auto;
	}
	img{width: 100px;}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption>${detail.bnum }번 도서 상세보기</caption>
			<tr>
				<th>책제목</th>
				<td>${detail.btitle }</td>
			</tr>
			<tr>
				<th>지은이</th>
				<td>${detail.bwriter }</td>
			</tr>
			<tr>
				<th>출판일</th>
				<td>${detail.brdate }</td>
			</tr>
			<tr>
				<th>이미지1</th>
				<c:if test="${detail.bimg1 eq null }">
					<td>이미지 없음</td>
				</c:if>
				<c:if test="${detail.bimg1 != null }">
					<td><img src="${conPath }/bookImgFileUpload/${detail.bimg1}"></td>
				</c:if>
			</tr>
			<tr>
				<th>이미지2</th>
				<c:if test="${detail.bimg2 eq null }">
					<td>이미지 없음</td>
				</c:if>
				<c:if test="${detail.bimg2 != null }">
					<td><img src="${conPath }/bookImgFileUpload/${detail.bimg2}"></td>
				</c:if>
			</tr>
			<tr>
				<th>책정보</th>
				<td>${detail.binfo }</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="뒤로" onclick="history.back();" class="btn">
					<input type="button" value="수정" onclick="location.href='book.do?method=modifyForm&bnum=${detail.bnum}&pageNum=${pageNum }'" class="btn">
					<input type="button" value="삭제" onclick="location.href='book.do?method=delete&bnum=${detail.bnum}&pageNum=${pageNum }'" class="btn">
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
