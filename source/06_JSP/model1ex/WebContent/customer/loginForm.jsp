<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/login.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="loginForm_wrap">
	<div id="login_title">로그인</div>
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" required="required" autofocus="autofocus"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" required="required"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인" class="loginBtn_style">
			</td>
		</tr>
	</table>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>