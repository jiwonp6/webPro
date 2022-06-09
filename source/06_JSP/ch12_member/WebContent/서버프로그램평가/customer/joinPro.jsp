<%@page import="java.sql.Date"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setBirth(Date.valueOf(tempbirth));
	}
	CustomerDao cDao = new CustomerDao();
	int result = cDao.confirmId(dto.getId());
	if(result == CustomerDao.SUCCESS){	//아이디 중복X
		result = cDao.joinCustomer(dto);	//회원가입
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", dto.getName());
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