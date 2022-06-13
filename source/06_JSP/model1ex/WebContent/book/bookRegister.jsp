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
<jsp:include page="../main/header.jsp"></jsp:include>
	<form action="bookRegisterPro.jsp" method="post" enctype="multipart/form-data">
		<table>
			<caption>책등록</caption>
			<tr>
				<th>책제목</th>
				<td><input type="text" name="btitle" maxlength="33" required="required"></td>
			</tr>
			<tr>
				<th>책가격</th>
				<td><input type="number" name="bprice" min="0" max="9999999" required="required"></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="bimage1"></td>
				<!-- name이 dto와 같으면 type="file"인 이미지 때문에 다른 것들도 bean태그 사용 불가 -->
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="bimage2"></td>
			</tr>
			<tr>
				<th>책소개</th>
				<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<th>할인율</th>
				<td><input type="number" name="bdiscount" min="0" max="100" value="0"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="책등록" class="btn">
				</td>
			</tr>
		</table>
	</form>	
<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>
