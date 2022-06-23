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
	<style>
		div.main{
			width:100%;
			height:500px;
		}
		.main h1{
			text-align: center;
			line-height: 500px;
		}
	</style>
</head>
<body>
	<c:if test="${not empty loginErrorMsg }">
		<script>
			alert('${loginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty adminloginErrorMsg }">
		<script>
			alert('${adminloginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty modifyResult && empty withdrawalMsg}">
		<script>
			alert('${modifyResult}');
		</script>
	</c:if>
	<c:if test="${not empty modifyErrorMsg }">
		<script>
			alert('${modifyErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty withdrawalResult }">
		<script>
			alert('${withdrawalResult}');
		</script>
	</c:if>
	<c:if test="${not empty withdrawalMsg }">
		<script>
			alert('${withdrawalMsg}');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div class="main">
		<h1>MAIN</h1>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
