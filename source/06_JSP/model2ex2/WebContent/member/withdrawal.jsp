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
	<jsp:include page="../main/header.jsp"/>
	<form action="${conPath }/withdrawal.do">
	<table>
		<caption>회원탈퇴</caption>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="mid" value="${member.mid }">
			</td>
		</tr>
		<tr>
			<th>비번</th>
			<td>
				<input type="password" name="mpw" >
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원탈퇴">
				<%-- <input type="button" value="회원탈퇴" onclick="location='${conPath }/withdrawal.do'"> --%>
			</td>
		</tr>
	</table>
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>