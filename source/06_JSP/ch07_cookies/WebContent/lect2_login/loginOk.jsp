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
	<%
	String id, pw;
	%>
	<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	if(id!=null && id.equals("aaa") && pw!=null && pw.equals("1111")){
		//로그인 처리
		Cookie cookie = new Cookie("id", id);
		cookie.setMaxAge(-1);	//유효시간은 브라우저 닫을 때까지
		response.addCookie(cookie);
		//사용자이름 새로운 쿠키에 배정(DB에서 가져온 이름 쿠키값으로)
		Cookie cookie2 = new Cookie("name", "박박박");
		cookie.setMaxAge(-1);
		response.addCookie(cookie2);
		response.sendRedirect("welcome.jsp");
	}else{
	%>
	<script>
		alert("아이디와 비밀번호가 일치하지 않습니다");
		location.href="login.html";
	</script>
	
	<%
	}
	%>

</body>
</html>