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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%!
	String driverMysql = "com.mysql.jdbc.Driver";
	String urlMysql = "jdbc:mysql://localhost:3306/parkdb";
	String uidMysql = "root";
	String upwMysql = "mysql";
	%>
	<table>
		<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PERSONAL";	//ctrl+shift+x 대문자로 변경
		try{
			// 1단계 : 드라이버 로드
			Class.forName(driverMysql);
			// 2단계 : DB연결객체
			conn = DriverManager.getConnection(urlMysql, uidMysql, upwMysql);
			// 3단계 : SQL전송객체
			stmt = conn.createStatement();
			// 4단계 : SQL전송 + 5단계 : 전송결과 받기
			rs= stmt.executeQuery(sql);
			// 6단계 : 결과를 이용해서 적당한 로직 수행
			if(rs.next()){
				//타이틀
				out.println("<tr><th>사번</th>"+
							"<th>이름</th>"+
							"<th>직책</th>"+
							"<th>상사사번</th>"+
							"<th>입사일</th>"+
							"<th>급여</th>"+
							"<th>상여</th>"+
							"<th>부서번호</th></tr>");
				do{
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					String startdate = rs.getString("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					out.println("<tr><td>"+pno+"</td>"+
								"<td>"+pname+"</td>"+
								"<td>"+job+"</td>"+
								"<td>"+manager+"</td>"+
								"<td>"+startdate+"</td>"+
								"<td>"+pay+"</td>"+
								"<td>"+bonus+"</td>"+
								"<td>"+dno+"</td></tr>" );
				}while(rs.next());
			}else{
				out.println("<tr><td>입력된 데이터가 없습니다</td></tr>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		%>
	</table>
</body>
</html>