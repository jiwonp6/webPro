<%@page import="java.util.Arrays"%>
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
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String birth = request.getParameter("birth");
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
	
	String ip = request.getRemoteAddr();	
	Date date = new Date(System.currentTimeMillis());	
	
	String pwx = "";
	for(int i=0; i<pw.length(); i++) {
		pwx += "*";
	}
	%>
	<div id="joinForm_wrap">
	<div id="join_title">회원가입정보</div>
	<h2>이름 : <%=name %></h2>
	<h2>아이디 : <%=id %></h2>
	<h2>비밀번호 : <%=pwx %></h2>
	<h2>생년월일 : <%=birth %></h2>
	<%
	out.println("<h2>취미 : ");
	for(int i=0; i<hobby.length; i++) {
		if(i == hobby.length-1) {
			out.println(hobby[i]);
		}else {
			out.println(hobby[i]+", ");
		}
	}
	out.println("</h2>");
	%>
	<h2>성별 : <%=gender %></h2>
	<h2>이메일 : <%=email %></h2>
	<%
	out.println("<h2>메일수신동의 : "+Arrays.deepToString(mailSend)+"</h2>");
	%>
	<h2>가입일 : <%=date %></h2>
	<h2>가입IP : <%=ip %></h2>
	
	</div>
	<%@ include file="../exam2/footer.jsp" %>
</body>
</html>