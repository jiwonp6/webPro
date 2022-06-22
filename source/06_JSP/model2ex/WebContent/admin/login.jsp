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
	<!-- ${requestScope.joinResult } -->
	<c:if test="${not empty requestScope.joinResult }">
		<script>
			alert('${joinResult}');
		</script>
	</c:if>
	<!-- ${requestScope.joinErrorMsg } -->
	<c:if test="${not empty requestScope.joinErrorMsg }">
		<script>
			alert('${joinErrorMsg}');
			history.back();
		</script>
	</c:if>
	<form action="${conPath }/login.do" method="post">
		<table>
		<caption>관리자모드 로그인</caption>
			<tr>
				<th>Admin ID</th>
				<td><input type="text" name="aid" value="${aid }" required="required"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="apw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location='${conPath}/joinView.do'">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>