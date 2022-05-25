<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>	<!-- eg) 127.0.0.1 : IPv4 -->
	<h2>요청한 곳의 주소 :  ★ <%=request.getRemoteAddr() %></h2>
	<h2>컨텍스트 path : ★  <%=request.getContextPath() %></h2>
	<h2>요청방식 : <%=request.getMethod() %></h2>
	<h2>세션객체 : ★ <%=request.getSession() %></h2>
	<h2>요청 url  : <%=request.getRequestURL() %></h2>
	<h2>요청 uri  : ★ <%=request.getRequestURI() %></h2>
	<h2>해당프로토콜 : <%=request.getProtocol() %></h2>
	<h2>서버 이름 : <%=request.getServerName() %></h2>
	<h2>포트번호 : <%=request.getServerPort() %></h2>
</body>
</html>