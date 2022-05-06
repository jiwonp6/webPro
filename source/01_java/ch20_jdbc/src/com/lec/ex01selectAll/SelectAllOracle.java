package com.lec.ex01selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;	//DB 연결 객체 변수
		Statement stmt = null;	//SQL 전송 객체 변수
		ResultSet rs = null;	//SELECT문 결과 받는 객체 변수
		String query = "SELECT * FROM EMP";
		
		try {
			//1. 드라이버 로드
			Class.forName(driver);
			//2. DB 연결
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//3. SQL 전송 객체 생성
			stmt = conn.createStatement();
			//4. SQL 전송 + 5. SQL 전송 결과 받기
			rs = stmt.executeQuery(query);
			//6. 결과 받아 원하는 로직 수행(결과는 rs가 받음)
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
			while(rs.next()) {	//rs가 맨마지막을 가리키면 false반환
				int empno = rs.getInt("empno");	//특수문자 없게 sql에서 네이밍 필요함
				String ename = rs.getString("ename");	//int형을 String으로 가져오면 String형으로 바꿔 가지고 옴
				String job = rs.getString("job");
				if(job.length()<6) {
					job = job+"\t";
				}
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				// = String hiredate = rs.getString("hiredate");	String으로 가져오면 시간까지 나옴
				// = Timestamp hiredate = rs.getTimestamp("hiredate");	 String이랑 비슷
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
						empno, ename, job, mgr, hiredate, sal, comm, deptno);	// TF로 받으면 timestamp로 받아서 생긴 시간 안나옴
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	//7. 연결 해제
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
