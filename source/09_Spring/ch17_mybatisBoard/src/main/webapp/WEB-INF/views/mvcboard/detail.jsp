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
	<c:if test="${updateResult eq SUCCESS }">
		<script>
			alert("글수정 성공");
		</script>
	</c:if>
	<c:if test="${updateResult eq FAIL }">
		<script>
			alert("글수정 실패");
			history.back();
		</script>
	</c:if>
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th><td>${board.bid }</td>
		</tr>
		<tr>
			<th>작성자</th><td>${board.bname }</td>
		</tr>
		<tr>
			<th>제목</th><td>${board.btitle }</td>
		</tr>
		<tr>
			<th>본문</th><td><pre>${board.bcontent }</pre></td>
		</tr>
		<tr>
			<th>작성일</th><td><fmt:formatDate value="${board.bdate }" pattern="yy/MM/dd(E)" /></td>
		</tr>
		<tr>
			<th>IP</th><td>${board.bip }</td>
		</tr>
		<tr>
			<th>조회수</th><td>${board.bhit }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location='${conPath }/mvcboard/delete.do?bid=${board.bid }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location='${conPath }/mvcboard/update.do?bid=${board.bid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location='${conPath }/mvcboard/reply.do?bid=${board.bid }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location='${conPath }/mvcboard/boardList.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>