<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	<form action="ex3_deptnoOut.jsp">
		부서번호
		<select name="deptno">
			<option value="0"></option>
				<%
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String driver = "oracle.jdbc.driver.OracleDriver";
				String sql = "SELECT DEPTNO, DNAME FROM DEPT";
				try{
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs= stmt.executeQuery(sql);
					if(rs.next()){
					do{
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						out.println("<option value="+deptno+">");
						out.println(dname+"("+deptno+")");
						out.println("</option>");
					}while(rs.next());
					}
				}catch(Exception e){
					
				}finally{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				}
				%>
		</select>
		<p><input type="submit" value="검색"></p>
	</form>
</body>
</html>