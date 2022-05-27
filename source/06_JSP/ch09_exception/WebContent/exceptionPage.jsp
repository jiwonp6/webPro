<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<% //크롬브라우저가 아닌경우 실행자체가 안됨 -> 500이지만 200으로 바꿔서 예외메세지 뿌려줌 %>
<%--
200:정상상태/
500:문법오류나 예외사항이 발생한 경우 
404:해당문서를 찾을 수 없을 때
407:인증을 받지 못한 경우
--%>
<%//예외페이지라고 지정해줌 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log('에외 메세지 : '+'<%=exception.getMessage() %>');
		console.log('에외 타입 : '+'<%=exception.getClass().getName() %>');
	</script>
</head>
<body>
	<h1>예외발생 예외발생</h1>
	<h1>0으로 못나눈다 이말이야~</h1>
	<%
	System.out.println("예외 메세지 : "+exception.getMessage());
	System.out.println("예외 타입 : "+exception.getClass().getName());
	%>
</body>
</html>