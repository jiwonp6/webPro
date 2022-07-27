<%@page import="com.lec.test1.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.test1.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/main/header.jsp"/>
	<table>
		<tr>
			<th>회원번호</th>
			<th>회원이름</th>
			<th>회원전화</th>
			<th>주소</th>
			<th>가입일</th>
			<th>고객등급</th>
			<th>도시코드</th>
		</tr>
		<%
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> dtos = mdao.memberList();
		for (MemberDto dto : dtos) {
		%>
			<tr>
				<td><a href="<%=conPath%>/member/modifyMember.jsp?custno=<%=dto.getCustno() %>"><%=dto.getCustno() %></a></td>
				<td><%=dto.getCustname() %></td>
				<td><%=dto.getPhone() %></td>
				<td><%=dto.getAddress() %></td>
				<td><%=dto.getJoindate() %></td>
				<td><%=dto.getGrade() %></td>
				<td><%=dto.getCity() %></td>
			</tr>
		<%
		}
		%>
	</table>
	<jsp:include page="/main/footer.jsp"/>
</body>
</html>