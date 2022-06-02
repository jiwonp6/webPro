<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@page import="com.lec.friend.FriendDto"%>
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
	<form action="friendInputListPro.jsp" method="post" name="join_frm">
			<p>친구이름<input type="text" name="name">
			전화<input type="text" name="phone1" value="010" size="2">
						 - <input type="text" name="phone2" size="2">
						 - <input type="text" name="phone3" size="2">
			
			<input type="submit" value="추가"></p>
		<table>
		<tr>
			<td>순번</td>
			<td>이름</td>
			<td>전화</td>
		</tr>
		<%
			FriendDao fdao = FriendDao.getInstance();
			ArrayList<FriendDto> fdtos = fdao.getFriend();
			for(FriendDto fdto : fdtos){
				out.println("<tr><td>"+fdto.getNum()+"</td>");
				out.println("<td>"+fdto.getName()+"</td>");
				out.println("<td>"+fdto.getPhone1()+"-");
				out.println(fdto.getPhone2()+"-");
				out.println(fdto.getPhone3()+"</td></tr>");
			}
		%>
		</table>
	
	</form>
</body>
</html>