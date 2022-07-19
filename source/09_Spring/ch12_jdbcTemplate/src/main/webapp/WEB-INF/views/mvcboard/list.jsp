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
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){
			/* $('tr').click(function(){
				var bId = Number($(this).children().eq(2).text());
				if(!isNaN(bId)){
					//alert(bId);
					location.href = '${conPath}/mvcboard/content.do?bId='+bId+'&pageNum=${pageNum}';
				}
			}); */
		});
		function trClicked(bId){
			//alert(bId);
			location.href = '${conPath}/mvcboard/content.do?bId='+bId+'&pageNum=${pageNum}';
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<!-- 글쓰기 성공/실패 alert -->
	<c:if test="${writeResult eq SUCCESS }">
		<script>
			alert("글쓰기 성공");
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>
			alert("글쓰기 실패");
			history.back();
		</script>
	</c:if>
	<!-- 글삭제 성공/실패 alert -->
	<c:if test="${deleteResult eq SUCCESS }">
		<script>
			alert("글삭제 성공");
		</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL }">
		<script>
			alert("글삭제 실패");
			history.back();
		</script>
	</c:if>
	<!-- 글답변 성공/실패 alert -->
	<c:if test="${replyResult eq SUCCESS }">
		<script>
			alert("답변글 작성 성공");
		</script>
	</c:if>
	<c:if test="${replyResult eq FAIL }">
		<script>
			alert("답변글 작성 실패");
			history.back();
		</script>
	</c:if>
	<c:set var="ordNum" value="${orderNum }"/>
	<c:set var="invNum" value="${inverseNum }"/>
	<table>
		<tr>
			<td><a href="${conPath }/mvcboard/writeView.do">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>순번</th>
			<th>역순</th>
			<th>글번호</th>
			<th>글쓴이</th>
			<th>글제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${totCnt == 0 }">
			<tr>
				<td colspan="7">등록된 글이 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach items="${boardList }" var="bDto">
				<tr	onclick="trClicked(${bDto.bId})">
					<td>
						${ordNum }
					</td>
		  				<c:set var="ordNum" value="${ordNum+1 }"/>
	  				<td>
	  					${invNum }
	  				</td>
		  				<c:set var="invNum" value="${invNum-1 }"/>
	  				<td>${bDto.bId }</td>
	  				<td>${bDto.bName }</td>
					<td class="left">
	  					<c:forEach var="i" begin="1" end="${bDto.bIndent }">
	  						<c:if test="${i==bDto.bIndent }">
	  							└
	  						</c:if>
	  						<c:if test="${i!=bDto.bIndent }">
	  								&nbsp; &nbsp; &nbsp;
	  						</c:if>
	  					</c:forEach>
	  					${bDto.bTitle }
	  				</td>
					<td>
	  					<fmt:formatDate value="${bDto.bDate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
	  				</td>
	  				<td>
	  					<fmt:formatNumber value="${bDto.bHit }" groupingUsed="true"/>	<!-- 3자리수 마다 , -->
	  				</td>
						
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
	  	<c:if test="${startPage > BLOCKSIZE }">
	  		[ <a href="${conPath }/mvcboard/list.do?pageNum=${startPage-1 }"> 이 전 </a>]
	  	</c:if>
	  	<c:forEach var="i" begin="${startPage }" end="${endPage }">
	  		<c:if test="${i eq pageNum }">
	  			[ <b>${i }</b> ]
	  		</c:if>
	  		<c:if test="${i != pageNum }">
	  			[ <a href="${conPath }/mvcboard/list.do?pageNum=${i }">${i }</a> ]
	  		</c:if>
	  	</c:forEach>
	  	<c:if test="${endPage<pageCnt }">
	  		[ <a href="${conPath }/mvcboard/list.do?pageNum=${endPage+1 }"> 다 음 </a>]
	  	</c:if>
  	</div>
</body>
</html>