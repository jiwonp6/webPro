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
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<!-- 글수정 성공/실패 alert -->
	<c:if test="${modifyResult eq SUCCESS }">
		<script>
			alert("글수정 성공");
		</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>
			alert("글수정 실패");
			history.back();
		</script>
	</c:if>
	<%-- ${bDto }, ${param.bId }, ${param.pageNum } 들어옴--%>
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th><td>${bDto.bId }</td>
		</tr>
		<tr>
			<th>작성자</th><td>${bDto.bName }</td>
		</tr>
		<tr>
			<th>제목</th><td>${bDto.bTitle }</td>
		</tr>
		<tr>
			<th>본문</th><td><pre>${bDto.bContent }</pre></td>
		</tr>
		<tr>
			<th>작성일</th><td><fmt:formatDate value="${bDto.bDate }" pattern="yy/MM/dd(E)" /></td>
		</tr>
		<tr>
			<th>IP</th><td>${bDto.bIp }</td>
		</tr>
		<tr>
			<th>조회수</th><td>${bDto.bHit }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location='${conPath }/mvcboard/delete.do?bId=${param.bId }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location='${conPath }/mvcboard/modify.do?bId=${param.bId }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location='${conPath }/mvcboard/reply.do?bId=${param.bId }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location='${conPath }/mvcboard/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>