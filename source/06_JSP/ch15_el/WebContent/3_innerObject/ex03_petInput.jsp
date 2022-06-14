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
	<form action="ex04_petResult.jsp">
		<p>I D<input type="text" name="id"></p>
		<p>
			키우는 애완동물을 선택하세요
			<br>
			<input type="checkbox" name="pets" value="개">개
			<input type="checkbox" name="pets" value="고양이">고양이
			<input type="checkbox" name="pets" value="앵무새">앵무새
			<input type="checkbox" name="pets" value="고슴도치">고슴도치
		</p>
		<p><input type="submit"></p>
	</form>
</body>
</html>
