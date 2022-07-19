<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${fileResult eq '파일 업로드 성공' }">
		<script>
			alert("파일 업로드 성공");
		</script>
	</c:if>
	<c:if test="${fileResult eq '파일 업로드 실패' }">
		<script>
			alert("파일 업로드 실패");
			history.back();
		</script>
	</c:if>
	<h2>파일업로드 결과 : ${fileResult}</h2>
	<p>파일0(file1) : ${fileNames[0] }</p>
	<p>파일1(file2) : ${fileNames[1] }</p>
	<p>파일2(file3) : ${fileNames[2] }</p>
	<c:if test="${not empty fileNames[0]}">
		<!-- controller에 공통요청경로가 없어서 conPath 필요없지만 있는경우엔 conPath필요 -->
		<img src="${conPath }/upload/${fileNames[0] }" style="width: 250px;">		
	</c:if>
	<c:if test="${empty fileNames[0]}">
		파일0(file1) : 첨부파일없음
	</c:if>
	<c:if test="${not empty fileNames[1]}">
		<img src="${conPath }/upload/${fileNames[1] }" style="width: 250px;">
	</c:if>
	<c:if test="${empty fileNames[1]}">
		파일1(file2) : 첨부파일없음
	</c:if>
	<c:if test="${not empty fileNames[2]}">
		<img src="${conPath }/upload/${filename[2] }" style="width: 250px;">
	</c:if>
	<c:if test="${empty fileNames[2]}">
		파일2(file3) : 첨부파일없음
	</c:if>
</body>
</html>