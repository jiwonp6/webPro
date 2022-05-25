<%@page import="java.net.URLEncoder"%>
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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id==null || !id.equals("aaa") || pw==null || !pw.equals("1111")){
		String msg = "Check the ID and PW!";
		response.sendRedirect("ex5_loginFrm.jsp?msg="+msg);
		//String msgKor = "<b>아이디와 비밀번호를 확인해주세요</b>";
		//msgKor = URLEncoder.encode(msgKor, "utf-8");
		//response.sendRedirect("ex5_loginFrm.jsp?msg="+msgKor);
	}
	%>
	<h2>
		ID는 <%=id %>이고<br>
		비밀번호는 <%=pw %>로<br>
		인증에 성공되셨습니다<br>
		<br>
		반갑습니다
	</h2>
</body>
</html>