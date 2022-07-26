<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
#content {
	width: 800px;
	height: 500px;
	margin: 50px auto;
}
</style>
</head>
<body>
	<c:set var="SUCCESS" value="1"></c:set>
	<c:if test="${registerResult == SUCCESS }">
		<script>
			alert('책등록 완료');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="content">
		<form action="${conPath }/book.do?method=register" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>책제목</td>
					<td><input type="text" name="btitle" required="required"></td>
				</tr>
				<tr>
					<td>지은이</td>
					<td><input type="text" name="bwriter" required="required"></td>
				</tr>
				<tr>
					<td>출판일</td>
					<td><input type="date" name="brdate" required="required"></td>
				</tr>
				<tr>
					<td>이미지1</td>
					<td><input type="file" name="tempBimg1"></td>
				</tr>
				<tr>
					<td>이미지2</td>
					<td><input type="file" name="tempBimg2"></td>
				</tr>
				<tr>
					<td>책정보</td>
					<td><textarea rows="5" cols="10" name="binfo"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="책등록" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
