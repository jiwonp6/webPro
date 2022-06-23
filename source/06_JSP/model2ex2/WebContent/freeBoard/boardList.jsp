<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<c:set var="SUCCESS" value="1"/>
<c:set var="FAIL" value="0"/>
<c:if test="${not empty writeErrorMsg }">
	<script>
		alert('글쓰기 실패');
		history.back();
	</script>
</c:if>
<c:if test="${modifyResult eq SUCCESS }">
	<script>
		alert('글수정 성공');
	</script>
</c:if>
<c:if test="${modifyResult eq FAIL }">
	<script>
		alert('글수정 실패');
	</script>
</c:if>
<c:if test="${deleteResult eq SUCCESS }">
	<script>
		alert('글삭제 성공');
	</script>
</c:if>
<c:if test="${deleteResult eq FAIL }">
	<script>
		alert('글삭제 실패');
	</script>
</c:if>
<script>
	$(document).ready(function(){
		$('tr').click(function(){
			var fid = Number($(this).children().eq(0).text());
			if(!isNaN(fid)){
				location.href = '${conPath}/boardContent.do?fid='+fid+'&pageNum=${pageNum}';
			}
		});
	});
</script>
	<jsp:include page="../main/header.jsp"/>
	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="${conPath }/boardWriteView.do">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>IP</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${list.size() eq 0 }">
			<tr>
				<td colspan="6">해당페이지 글이 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${list.size() != 0 }">
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.fid }</td>
					<!-- getter 있으면 그냥 호출 가능 -->
					<td>${dto.mid }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${dto.findent }">
							<c:if test="${i eq dto.findent }">
								└─
							</c:if>
							<c:if test="${i != dto.findent }">
								 &nbstp; &nbstp; 
							</c:if>
						</c:forEach> <!-- 답변글 들여쓰기 --> 
						<a>${dto.ftitle }</a>
						<c:if test="${dto.fhit>10 }">
							<b> * </b>
						</c:if></td>
					<!-- 글제목 -->
					<td>${dto.fip}</td>
					<td><fmt:formatDate value="${dto.frdate}" pattern="yy년 MM월dd일(E)"/></td>
					<td>${dto.fhit}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/BoardList.do?pageNum=${startPage -1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/BoardList.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/BoardList.do?pageNum=${endPage +1}">다음</a> ]
		</c:if>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>