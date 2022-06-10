<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%
	CustomerDao cDao = CustomerDao.getInstance();
	CustomerDto newCustomer = new CustomerDto();
	for(int i=0; i<10; i++){
		newCustomer.setCid("aa"+i);
		newCustomer.setCpw("111");
		if(i%2==0){
			newCustomer.setCname("박길동");
			newCustomer.setCgender("m");
		}else{
			newCustomer.setCname("박길자");
			newCustomer.setCgender("f");
		}
		newCustomer.setCtel("010-1234-127"+i);
		newCustomer.setCemail("park"+i+"@park.com");
		newCustomer.setCbirth(Date.valueOf("1995-12-12"));
		int result = cDao.insertCustomer(newCustomer);
		out.println(result==CustomerDao.SUCCESS ? i+"번째 성공":i+"번째 실패");
		out.println("<br>");
	}
%>