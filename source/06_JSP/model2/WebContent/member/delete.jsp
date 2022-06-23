<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>회원탈퇴</caption>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="aid" value="${admin.aid }">
			</td>
		</tr>
		<tr>
			<th>비번</th>
			<td>
				<input type="text" name="apw" >
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="회원탈퇴" onclick="location='${conPath}/adelete.do'">
			</td>
		</tr>
	</table>
</body>
</html>