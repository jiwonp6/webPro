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
	<link href="${conPath }/css/login.css" rel="stylesheet">
	<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<form action="${conPath }/login.do" method="post">
			<table>
				<caption>로그인</caption>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mId" required="required" 
								placeholder="아이디를 입력해주세요" style="width:250px; height:20px; font-size:12px; ">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<br>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mPw" required="required"
								placeholder="비밀번호를 입력해주세요" style="width:250px; height:20px; font-size:12px; ">
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="로그인" class="btn">
					<input type="button" value="회원가입" class="btn"	onclick="location.href='${conPath}/joinView.do'">
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>