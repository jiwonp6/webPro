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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>${contentView.fid }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${contentView.mid }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${contentView.ftitle }</td>
		</tr>
		<tr>
			<th>본문</th>
			<td><pre>${contentView.fcontent }</pre></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><img src="${conPath }/freeBoardUp/${contentView.ffilename }" width="100"></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${contentView.frdate }" pattern="yy/MM/dd(E)" /></td>
		</tr>
		<tr>
			<th>IP</th><td>${contentView.fip }</td>
		</tr>
		<tr>
			<th>조회수</th><td>${contentView.fhit }</td>
		</tr>
		<tr>
			<td colspan="2">
				<%-- <button onclick="location='${conPath }/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location='${conPath }/modify_view.do?bid=${param.bid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location='${conPath }/reply_view.do?bid=${param.bid }&pageNum=${param.pageNum }'">답변</button> --%>
				<button onclick="location='${conPath }/Boardlist.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>