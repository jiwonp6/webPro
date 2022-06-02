<%@page import="java.sql.DriverManager"%>
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
	<script>
		function btn(){
			var name = join_frm.name.value;
			var phone1 = join_frm.phone1.value;
			var phone2 = join_frm.phone2.value;
			var phone3 = join_frm.phone3.value;
			location.href="friendInputList2.jsp?name="+name+"&phone1="+phone1+"&phone2="+phone2+"&phone3="+phone3;
		}
	</script>
</head>
<body>
	<form action="friendInputListPro2.jsp" method="post" name="join_frm">
			<p>친구이름<input type="text" name="name" value="<% String name = request.getParameter("name"); %>">
			전화<input type="text" name="phone1" value="<% String phone1 = request.getParameter("phone1"); %>" size="2">
				 - <input type="text" value="<% String phone2 = request.getParameter("phone2"); %>" name="phone2" size="2">
				 - <input type="text" value="<% String phone3 = request.getParameter("phone3"); %>" name="phone3" size="2">
			<input type="button" value="검색" onclick="btn()">
			<input type="submit" value="추가"></p>
		<table>
		<tr>
			<td>순번</td>
			<td>이름</td>
			<td>전화</td>
		</tr>
		<%	
			FriendDao fdao = FriendDao.getInstance();
			ArrayList<FriendDto> fdtos = fdao.findFriend(name, phone1, phone2, phone3);
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