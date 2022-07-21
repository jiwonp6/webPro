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
<link href="${conPath}/css/board.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
		function trclicked(empno) {
			//해당 empno 사원의 상세보기 페이지
			location.href='${conPath }/detail.do?empno='+empno+'&pageNum=${paging.currentPage }';
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" property="1"/>
	<c:set var="FAIL" property="0"/>
	<c:if test="${not empty updateResult }">
		<script>
			alert("회원정보수정 성공");
		</script>
	</c:if>
	<c:if test="${deleteResult eq 1 }">
		<script>
			alert("회원삭제 성공");
		</script>
	</c:if>
	<c:if test="${deleteResult eq 0 }">
		<script>
			alert("회원삭제 실패");
		</script>
	</c:if>
	<c:if test="${insertResult eq 1 }">
		<script>
			alert("회원등록 성공");
		</script>
	</c:if>
	<c:if test="${insertResult eq 0 }">
		<script>
			alert("회원등록 실패");
		</script>
	</c:if>
	
	<c:set var="num" value="${paging.totCnt - paging.startrow + 1 }" />
	<table>
		<caption>직원 목록</caption>
		<tr>
			<td colspan="6" align="right">
				<a href="${conPath }/empList.do">empList로 보기</a>
				<a href="${conPath }/insertView.do">직원등록</a>
			</td>
		</tr>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>업무</th>
			<th>입사일</th>
			<th>부서명</th>
			<th>근무지</th>
		</tr>
		<c:forEach items="${empDeptList }" var="emp">
			<tr onclick="trclicked(${emp.empno})">
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td>
					<fmt:formatDate value="${emp.hiredate }" dateStyle="long" />
				</td>
				<td>${emp.dname }</td>
				<td>${emp.loc }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<div id="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[ <a href="${conPath }/empDeptList.do?pageNum=${paging.startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${paging.currentPage eq i }">
				[ <b> ${i }</b> ]
			</c:if>
			<c:if test="${paging.currentPage != i }">
				[ <a href="${conPath }/empDeptList.do?pageNum=${i}"> ${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage<paging.pageCnt }">
			[ <a href="${conPath }/empDeptList.do?pageNum=${paging.endPage+1}">다음</a> ]
		</c:if>
	</div>
</body>
</html>