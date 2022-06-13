<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCheck(cid,cpw);
	if(result==CustomerDao.SUCCESS){	//로그인 성공
		CustomerDto customer = cDao.getCustomer(cid);
		session.setAttribute("customer", customer);
		response.sendRedirect("../main/main.jsp?msg=success");
	}else if(result==CustomerDao.FAIL){	
		response.sendRedirect("loginForm.jsp?msg=xx");
	}
	%>
</body>
</html>