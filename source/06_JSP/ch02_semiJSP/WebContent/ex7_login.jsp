<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>
</head>
<body>
<form action="ex7_loginPro.jsp" method="post">
	<table>
	<tr>
	<td>이 름</td>
	<td>
		<input type="text" name="name">
	</td>
	</tr>
	<tr>
	<td>아 이 디</td>
	<td>
		<input type="text" name="id">
	</td>
	</tr>
	<tr>
	<td>패스워드</td>
	<td>
		<input type="password" name="pw">
	</td>
	</tr>
	<tr >
		<td colspan="2"><input onclick="btn" type="submit" value="로그인"></td>
	</tr>
	</table>
</form>
</body>
</html>