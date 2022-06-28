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
	<link href="conPath/css/itemboardList.css" rel="stylesheet">
	<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
	<style>
		#content_form {
			width: 800px; height:470px;
			margin: 30px auto 0px;
		}
		#content_form table tr { height: 10px;}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('tr').click(function(){
				var iId = Number($(this).children().eq(0).text()); // 0번째 td안의 있는 text;
				if(!isNaN(iId)){
					location.href = '${conPath}/itemboardContent.do?iId='+iId+'&pageNum=${pageNum}';
				}
			});
		});
	</script>
</head>
<body>
	<c:if test="${empty member }">
		<script>
			alert('로그인 이후 이용가능 합니다');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty itemboaredResult }">
		<script>alert('${itemboaredResult}');</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<p>
			<c:if test="${not empty member }">
				<a href="${conPath }/itemboardWriteView.do">글쓰기</a>
			</c:if>
		</p>
	<br>
	<table>
		<tr>
			<th>글번호</th><th>글제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
		</tr>
		<tr>
			<td colspan="5">
				<hr>
			</td>
		</tr>
		<c:if test="${totCnt==0 }">
			<tr><td colspan="6">등록된 글이 없습니다</td></tr>
		</c:if>
		<c:if test="${totCnt!=0 }">
			<c:forEach items="${itemboardList }" var="itemboard">
				
				<tr>
					<td>${itemboard.iId }</td>
					<td class="left">
						<c:forEach var="n" begin="1" end="${itemboard.iIndent }">
							<c:if test="${n==itemboard.iIndent }">└─</c:if>
							<c:if test="${n!=itemboard.iIndent }"> &nbsp; &nbsp; </c:if>
						</c:forEach>
						${itemboard.iTitle } <!-- 글제목에 a태그를 걸지 말고 query로 tr을 클릭하면 상세보기 페이지로 가기 -->
						<c:if test="${not empty itemboard.iFilename }">
							<img src="https://cdn-icons-png.flaticon.com/512/5088/5088374.png" width="10">
						</c:if>
					</td>
					<td>${itemboard.mId }</td>
					<td>${itemboard.iHit }</td>
					<td><fmt:formatDate value="${itemboard.iRdate }" type="date" dateStyle="short"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/itemboardList.do?pageNum=${startPage-1 }"> 이전 </a> ]
		</c:if>
		<c:forEach var="n" begin="${startPage }" end="${endPage }">
			<c:if test="${n == pageNum }">
				<b> [ ${n } ] </b>
			</c:if>
			<c:if test="${n != pageNum }">
				[ <a href="${conPath }/itemboardList.do?pageNum=${n }"> ${n } </a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage<pageCnt }">
		  [ <a href="${conPath }/itemboardList.do?pageNum=${endPage+1}"> 다음 </a> ]
		</c:if>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>