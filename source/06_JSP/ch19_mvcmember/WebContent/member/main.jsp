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
	<c:if test="${not empty modifyResult }">
		<script type="text/javascript">
			alert('${modifyResult}');
		</script>
	</c:if>
	<c:if test="${not empty modifyErrorMsg }">
		<script type="text/javascript">
			alert('${modifyErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty loginErrorMsg }">
		<script type="text/javascript">
			alert('${loginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.member }">
		<h2>${member.mname }님 어서오세요</h2>
		<form action="" method="post"> 
		<table>
			<tr>
				<td>
					<input type="button" value="정보수정" onclick="location='${conPath}/modifyView.do'">
					<input type="button" value="로그아웃" onclick="location='${conPath}/mLogout.do'">
					<input type="button" value="전체회원보기" onclick="location='${conPath}/mAllView.do'">
				</td>
			</tr>
		</table>
		</form>	
	</c:if>
	<c:if test="${empty sessionScope.member }">
		<h2>로그인 상태가 아닙니다</h2>
		<form action="" method="post"> 
		<table>
			<tr>
				<td>
					<input type="button" value="로그인" onclick="location='${conPath}/loginView.do'">
					<input type="button" value="회원가입" onclick="location='${conPath}/joinView.do'">
					<input type="button" value="전체회원보기" onclick="location='${conPath}/mAllView.do'">
				</td>
			</tr>
		</table>
		</form>	
	</c:if>
</body>
</html>