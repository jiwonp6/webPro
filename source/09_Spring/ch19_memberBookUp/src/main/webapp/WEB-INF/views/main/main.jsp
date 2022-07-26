<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:350px;
		margin: 50px auto;
	}
	img{width: 100px;}
</style>
</head>
<body>
	<c:set value="1" var="SUCCESS"/>
	<c:set value="0" var="FAIL"/>
	<c:if test="${joinMemberResult eq SUCCESS }">
		<script>
			alert("회원가입 성공");
		</script>
	</c:if>
	<c:if test="${joinMemberResult eq FAIL }">
		<script>
			alert("회원가입 실패");
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty modifyResult }">
		<script> alert("정보 수정이 완료 되었습니다");</script>
	</c:if>
	<c:if test="${not empty logoutResult }">
		<script> alert("${logoutResult }");</script>
	</c:if>
	<c:if test="${not empty drawalMemberResult }">
		<script> alert("회원탈퇴가 완료 되었습니다.");</script>
	</c:if>
	<jsp:include page="header.jsp"/>
	<div id="content">
		<table>
			<caption>신규 도서 BEST 5</caption>
			<tr><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th></tr>
			<tr>
			<c:forEach var="book" items="${mainList }" begin="0" end="4">
				<td>
				   ${book.btitle }<br>
				   <a href="${conPath }/book.do?method=detail&bnum=${book.bnum}&pageNum=1">
				   <img src="${conPath }/bookImgFileUpload/${book.bimg1}"></a><br>
				   ${book.bwriter } 著 <br>
				   출판일 : ${book.brdate }
				</td>
			</c:forEach>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>