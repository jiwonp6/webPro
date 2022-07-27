<%@page import="com.lec.test1.dto.MemberDto"%>
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
	<%
	int custno = Integer.parseInt(request.getParameter("custno"));
	MemberDao mDao = MemberDao.getInstance();
	MemberDto dto = mDao.getMember(custno);
	%>
	<form action="modifyMemberOk.jsp" method="post">
		<table>
			<caption>회원등록</caption>
			<tr>
				<th><p>회원번호(자동발생)</p></th>
				<td><input type="text" name="custno" value="<%=dto.getCustno() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname" required="required" value="<%=dto.getCustname() %>"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="text" name="phone" value="<%=dto.getPhone() %>"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address" value="<%=dto.getAddress() %>"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="date" name="tempdate" value="<%=dto.getJoindate() %>"></td>
			</tr>
			<tr>
				<th>고객등급<br>(A:VIP, B:일반, C:직원)</th>
				<td><input type="text" name="grade" value="<%=dto.getGrade() %>">
			</tr>
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city" value="<%=dto.getCity() %>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="조회" onclick="location.href='<%=conPath %>/member/memberList.jsp'">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="/main/footer.jsp"/>
</body>
</html>