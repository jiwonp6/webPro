<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	table{
		width:1000px;
		height:500px;
		overflow:hidden;
		margin: 10px auto;
		border:1px solid red;
	}
	tr> td{
		float:left;
		width:100px;
		border:1px solid red;
	}
	
	</style>
</head>
<body>
	<table>
	<%
	int su1 = Integer.parseInt(request.getParameter("su1"));
	int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h3><%=su1 %>단 부터 <%=su2 %>단 까지 구구단 출력</h3>
	<tr>
	<%
	for(int i=su1; i<=su2; i++){
	%>
	<td>
			<p><h4><%=i %>단 출력</h4></p>
	<%
		for(int j=1; j<10; j++){
	%>
			<p><%=i %>*<%=j %> = <%=i*j %></p>
	<%
		}
	%>
	</td>
	<%
	}
	%>
	</tr>
	</table>
	<button onclick="history.go(-1);">뒤로가기</button>
	<button onclick="location.href='ex6_su2Input.html';">새로하기</button>
</body>
</html>