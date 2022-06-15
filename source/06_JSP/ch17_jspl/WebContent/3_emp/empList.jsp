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
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사</th><th>입사</th><th>급여</th><th>상여</th><th>부서</th>
		</tr>
		<c:if test="${emps.size() eq 0 }">
			<tr>
				<td colspan="8">등록된 사원이 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${emps.size() != 0 }">
			<c:forEach items="${emps }" var="emp">
				<tr>
					<td>${emp.empno }</td>
					<td>
						<c:if test="${emp.sal>2000 }">
							<img alt="" src="${conPath }/img/hot.gif">	<!-- servlet에서 실행되서 넘어오기 때문에 servlet이라고 생각함 => ../~가 안됨 -->
						</c:if>
						<c:if test="${emp.sal eq 0 }">
							<b style="color:navy;">${emp.ename }</b>
						</c:if>
						<c:if test="${emp.sal != 0 }">
							${emp.ename }
						</c:if>
					</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td>
						<fmt:formatDate value="${emp.hiredate }" pattern="yyyy년 MM월dd일(E) hh:mm:ss(a)"/>
					</td>
					<td>
						<fmt:formatNumber value="${emp.sal }" groupingUsed="true"/>
					</td>
					<td>${emp.comm }</td>
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>