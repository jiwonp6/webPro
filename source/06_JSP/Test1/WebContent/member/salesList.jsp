<%@page import="com.lec.test1.dto.SalesListDto"%>
<%@page import="com.lec.test1.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.test1.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/main/header.jsp"/>
	<section>
	<table>
		<caption>회원 매출 조회</caption>
		<tr>
			<th>회원번호</th>
			<th>회원이름</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
		<%
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<SalesListDto> dtos = mdao.memberSalesList();
		for (SalesListDto dto : dtos) {
		%>
			<tr>
				<td><%=dto.getCustno() %></td>
				<td><%=dto.getCustname() %></td>
				<td><%=dto.getGname() %></td>
				<td><%=dto.getSum() %></td>
			</tr>
		<%
		}
		%>
	</table>
	<table>
		<caption>제품 매출 조회</caption>
		<tr>
			<th>제품코드</th>
			<th>매출</th>
		</tr>
		<%
		ArrayList<SalesListDto> dtos2 = mdao.productSalesList();
		for (SalesListDto dto : dtos2) {
		%>
			<tr>
				<td><%=dto.getPcode() %></td>
				<td><%=dto.getSum() %></td>
			</tr>
		<%
		}
		%>
	</table>
	</section>
	<jsp:include page="/main/footer.jsp"/>
</body>
</html>