<%@page import="java.sql.Date"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setCbirth(Date.valueOf(tempbirth));
	}
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	String sessionCpw = null;
	if(customer!=null){
		sessionCpw = customer.getCpw();
	}
	String oldpw = request.getParameter("oldpw");
	if(sessionCpw.equals(oldpw)){
		if(dto.getCpw()==null){
			dto.setCpw(oldpw);
		}
		CustomerDao cDao = CustomerDao.getInstance();
		
		int result = cDao.updateCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("customer", dto);
			%>
			<script>
				alert('회원정보수정완료');
				location.href='../main/main.jsp';
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