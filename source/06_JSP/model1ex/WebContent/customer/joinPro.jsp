<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setCbirth(Date.valueOf(tempbirth));
	}
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmCid(dto.getCid());
	if(result == CustomerDao.SUCCESS){	//아이디 중복X
		result = cDao.insertCustomer(dto);	//회원가입
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("id", dto.getCid());
			session.setAttribute("name", dto.getCname());
			%>
			<script>
				alert('회원가입 감사합니다. 로그인 후 이용해 주세요');
				location.href='login.jsp';
			</script>
			<%
		}
	}else{
		%>
		<script>
			alert('회원가입이 실패되었습니다.');
			history.back();
		</script>
		<%
	}
	%>
</body>
</html>