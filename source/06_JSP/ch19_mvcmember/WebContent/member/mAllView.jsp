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
		<c:if test="${empty mAllView }">
			<tr>
				<td>등록된 회원이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty mAllView }">
		<tr>
			<c:forEach var="mdto" items="${mAllView }">
					<td>
						<p><img src="${conPath }/memberPhotoUp/${mdto.mphoto}" width="100"></p>
						<p>${mdto.mname }</p>
						<p>${mdto.mid }</p>
					</td>
			</c:forEach>
		</tr>
		</c:if>
	</table>
	<div class="paging">
		[ <a href="${conPath }/mAllView.do?pageNum=1"> &lt;&lt; </a> ]
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/mAllView.do?pageNum=${startPage -1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/mAllView.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/mAllView.do?pageNum=${endPage +1}">다음</a> ]
		</c:if>
		[ <a href="${conPath }/mAllView.do?pageNum=${pageCnt }"> &gt;&gt; </a> ]
	</div>
</body>
</html>