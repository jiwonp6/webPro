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
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<!-- jquery-ui 이용한 캘런더api -->
	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker(
					{
						dateFormat : 'yy-mm-dd',
						monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
								'8월', '9월', '10월', '11월', '12월' ],
						dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
						showMonthAfterYear : true,
						showOtherMonths : true,
						selectOtherMonths : false,
						yearSuffix : '년',
					});
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content">
		<form action="${conPath }/book.do" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="method" value="modify"> <input
				type="hidden" name="pageNum" value="${param.pageNum }"> <input
				type="hidden" name="bnum" value="${bookDetail.bnum }">
			<table>
				<caption>${bookDetail.bnum }번도서 수정하기</caption>
				<tr>
					<td>책제목</td>
					<td><input type="text" name="btitle"
						value="${bookDetail.btitle }"></td>
				</tr>
				<tr>
					<td>지은이</td>
					<td><input type="text" name="bwriter"
						value="${bookDetail.bwriter }"></td>
				</tr>
				<tr>
					<td>출판일</td>
					<td><input type="date" name="brdate"
						value="${bookDetail.brdate }"></td>
				</tr>
				<tr>
					<td>이미지1</td>
					<td><input type="file" name="tempBimg1"
						value="${bookDetail.bimg1 }"></td>
				</tr>
				<tr>
					<td>이미지2</td>
					<td><input type="file" name="tempBimg2"
						value="${bookDetail.bimg2 }"></td>
				</tr>
				<tr>
					<td>책정보</td>
					<td><input type="text" name="binfo"
						value="${bookDetail.binfo }"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" class="btn">
						<input type="button" value="목록"
						onclick="location='book.do?method=list&pageNum=${param.pageNum}'"
						class="btn"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
