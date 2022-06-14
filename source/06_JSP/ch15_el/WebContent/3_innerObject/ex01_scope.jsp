<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<form action ="ex02_scope.jsp">
		<p>이름 : <input type="text" name="name"></p>
		<p>I D : <input type="text" name="id"></p>
		<p>비번 : <input type="password" name="pw"></p>
		<p><input type="submit"></p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		//페이지 벗어나기 전까지 유효
		request.setAttribute("requestName", "requestValue");
		//새로운 객체 요청 전까지 유효
		session.setAttribute("sessionName", "sessionValue");
		//브라우저 끄기 전까지 유효
		application.setAttribute("applicationName", "applicationValue");
		//컴퓨터 끄기 전까지 유효
		
		//forward 할 객체 (dispatcher)
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=kim&id=aaa&pw=111");
 		dispatcher.forward(request, response);
	%>
		<%-- <jsp:forward page="ex02_scope.jsp"/> 	 setAttribute다음에 위치 --%>
	<hr>
	<h3>페이지 내 속성변수 값 : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 내 속성변수 값 : <%=request.getAttribute("requestName") %></h3>	
	<h3>session 내 속성변수 값 : <%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 속성변수 값 : <%=application.getAttribute("applicationName") %></h3>
	<hr>
	<h3>페이지 내 속성변수 값 : ${pageScope.pageName }</h3>
	<h3>request 내 속성변수 값 : ${requestScope.requestName }</h3>
	<h3>session 내 속성변수 값 : ${sessionScope.sessionName }</h3>
	<h3>application 내 속성변수 값 : ${applicationScope.applicationName }</h3>
	<hr>
	<h3>페이지 내 속성변수 값 : ${pageName }</h3>
	<h3>request 내 속성변수 값 : ${requestName }</h3>
	<h3>session 내 속성변수 값 : ${sessionName }</h3>
	<h3>application 내 속성변수 값 : ${applicationName }</h3>
	
</body>
</html>