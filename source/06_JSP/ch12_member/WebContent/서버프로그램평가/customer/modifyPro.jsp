<%@page import="java.sql.Date"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setBirth(Date.valueOf(tempbirth));
	}
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	String sessionPw = null;
	if(customer!=null){
		sessionPw = customer.getPw();
	}
	String oldpw = request.getParameter("oldpw");
	if(sessionPw.equals(oldpw)){
		if(dto.getPw()==null){
			dto.setPw(oldpw);
		}
		CustomerDao cDao = new CustomerDao();
		int result = cDao.modifyCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("customer", dto);
			%>
			<script>
				alert('회원정보수정완료');
				location.href='main.jsp';
			</script>
		<%
		}else{	//수정실패
		%>
			<script>
				alert('회원정보수정실패');
				history.back();
			</script>
		<%	
		}
	}else{
		%>	
		<script>
			alert('현 비밀번호가 바르지 않습니다');
			history.back();
		</script>
	<%
	}
	%>
</body>
</html>