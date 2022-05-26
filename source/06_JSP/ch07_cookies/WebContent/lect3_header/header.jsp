<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		header{
			width:1000px;
			margin:0 auto;
		}
		header #nav ul{
			overflow:hidden;
		}
		header #nav ul li{
			list-style:none;
			float:right;
			padding:10px 30px;
		}
		header #nav ul li a{
			text-decoration: none;
			font-weight: bold;
			font-size: 1.5em;
			color : #A47160;
		}
	</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
			String id=null;
			Cookie[] cs = request.getCookies();
			if(cs!=null){
				for(Cookie c : cs){
					if(c.getName().equals("id")){
						id = c.getValue();
						break;
					}
				}
			}
			%>
			<%
			if(id==null){	//로그인 전 헤더
			%>
				<ul>
					<li><a href="join.jsp">회원가입</a>
					<li><a href="login.jsp">로그인</a>
					<li><a href="main.jsp">홈</a>
				</ul>
			<%
			}else{	//로그인 후 헤더
			%>
				<ul>
					<li><a href="logout.jsp">로그아웃</a>
					<li><a href="clist.jsp">쿠키리스트</a>
					<li><a href="#"><%=id %>님</a>
				</ul>
			<%
			}
			%>
		</div>
	</header>
</body>
</html>