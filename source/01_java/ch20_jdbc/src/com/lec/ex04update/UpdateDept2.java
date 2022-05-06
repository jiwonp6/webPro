package com.lec.ex04update;
//수정하고자 하는 부서번호 입력 -> 존재하는 부서번호인지 체크 -> 부서명과 위치를 받아 수정
//입력한 부서번호가 있는지 없는지 체크
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");	
			do {
			System.out.println("수정할 부서번호?");
			int deptno = sc.nextInt();
			//	입력한 부서번호가 있는지 없는지 체크
			String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt<=0) {
				System.out.println("해당 부서는 존재하지 않습니다.");
			}else {
				System.out.println("수정할 부서명?");
				String dname = sc.next();
				System.out.println("수정할 위치?");
				String loc = sc.next();
				String sql = "UPDATE DEPT SET DNAME = '"+dname+"', LOC = '"+loc+"' WHERE DEPTNO = "+deptno;
				int result = stmt.executeUpdate(sql);
				System.out.println("수정성공");
				break;
			}
			}while(true);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {}
		}
	}
}
