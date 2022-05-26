<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	boolean outOk = false;	//선언부가 아니면 초기화가 필요하다.
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(Cookie c:cs){
			String cname = c.getName();
			String cvalue = c.getValue();
			if(cname.equals("id") || cname.equals("name")){
				out.println("<h3>"+cname+"(쿠키이름) / "+cvalue+"(쿠키값)</h3>");
				outOk = true;
			}
		}
	}
	if(!outOk){
		out.println("<h3>생성된 쿠키가 없습니다</h3>");
	}
	%>
	<button onclick="history.back()">이전페이지</button>
	<button onclick="location.href='welcome.jsp'">welcome페이지</button>
</body>
</html>