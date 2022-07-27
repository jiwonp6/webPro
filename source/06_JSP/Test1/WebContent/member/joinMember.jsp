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
	<%
	MemberDao mDao = MemberDao.getInstance();
	int max = mDao.getMAX_Custno();
	%>
	<form action="joinMemberOk.jsp" method="post">
		<table>
			<caption>회원등록</caption>
			<tr>
				<th><p>회원번호(자동발생)</p></th>
				<td><input type="text" name="custno" value="<%=max +1 %>"></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname" required="required"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="date" name="tempdate"></td>
			</tr>
			<tr>
				<th>고객등급<br>(A:VIP, B:일반, C:직원)</th>
				<td><input type="text" name="grade">
			</tr>
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="button" value="조회" onclick="location.href='<%=conPath %>/member/memberList.jsp'">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="/main/footer.jsp"/>
</body>
</html>