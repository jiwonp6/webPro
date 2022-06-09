<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<form action="ex1_fileupPro.jsp" method="post" enctype="multipart/form-data">
							<!-- get방식은 파일전달 불가 	/ 서로 다른 사용자가 추가한 파일의 이름이 같을 때 처리해줄 객체 사용	-->
		<p>파일<input type="file" name="file"></p>
		<input type="submit" value="파일업로드" class="btn">
	</form>
</body>
</html>