<%@page import="com.lec.customer.CustomerDto"%>
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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	CustomerDao cDao = new CustomerDao();
	int result = cDao.loginCheck(id,pw);
	if(result==CustomerDao.SUCCESS){	//로그인 성공
		CustomerDto customer = cDao.getCustomer(id);
		session.setAttribute("customer", customer);
		session.setAttribute("id", id);
		session.setAttribute("name", customer.getName());
		session.setAttribute("pw", pw);
		response.sendRedirect("main.jsp?msg=success");
	}else if(result==CustomerDao.FAIL){	
		response.sendRedirect("login.jsp?msg=xx");
	}
	%>
</body>
</html>