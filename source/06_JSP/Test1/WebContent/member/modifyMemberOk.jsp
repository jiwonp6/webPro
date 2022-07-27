<%@page import="com.lec.test1.dao.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.test1.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.test1.dto.MemberDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
	String tempdate = request.getParameter("tempdate");
	if(!tempdate.equals("")){
		dto.setJoindate(Date.valueOf(tempdate));
	}
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.FAIL;
	result = mDao.modifyMember(dto);
	if(result == mDao.SUCCESS){
	%>
		<script>
			alert('정보수정 성공');
			location.href='memberList.jsp';
		</script>
	<%
	}else{
	%>
		<script>
			alert('정보수정 실패. 다시 기입해주세요.');
			location.href='history.go(-1)';
		</script>
	<%
	}
	%>
</body>
</html>