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
	// 내장객체 request 이용하여 받은 파라미터 값은 String
	// 먼저 실행하면 파라미터를 안받으므로 parent를 실행 or
		// http://localhost:8090/ch02_semiJSP/ex5_gugudanOut.jsp?su=x이용
	int su = Integer.parseInt(request.getParameter("su"));
	%>
	<h3><%=su %>단 구구단</h3>
	<table>
		<%
		for(int i=1; i<=9; i++){
		%>	
		<tr><td>2*<%=i %> = <%=2*i %></td></tr>
		<%
		}
		%>
	</table>
</body>
</html>