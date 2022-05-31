<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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
	<%
	//String ename = request.getParameter("ename");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.driver.OracleDriver";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER(?)||'%'";
	%>
	<%
	String name = request.getParameter("name");
	%>
	<form action="">
		이름 검색
		<input type="text" id="name" name="name" value="<%if(name!=null)  out.print(name.toUpperCase());%>">
		<!-- text타입 안에 value 넣어주기 위해  if문 사용-->
		<input type="submit" value="검색">
		
		<table>
		<%
		try{
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			name = request.getParameter("name");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				out.println("<tr><th>이름</th><th>입사일</th><th>급여</th><th>부서번호</th></tr>");
				do{
					String ename = rs.getString("ename");
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int deptno = rs.getInt("deptno");
					out.println("<tr><td>"+ename+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+deptno+"</td></tr>");
				}while(rs.next());
			}else{
				out.println("<tr><td>해당 이름의 사원이 없습니다</td></tr>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
		}
		%>
		</table>
	</form>
</body>
</html>