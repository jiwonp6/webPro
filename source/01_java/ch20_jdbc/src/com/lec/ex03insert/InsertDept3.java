package com.lec.ex03insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			do {
				System.out.println("입력할 부서번호는 ?");
				int deptno = sc.nextInt();
				String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectSQL);
				if (rs.next()) {
					System.out.println("이미 존재하는 부서번호 입니다.");
				} else {
					System.out.println("입력할 부서명은 ?");
					String dname = sc.next();
					System.out.println("입력할 부서 위치는?");
					String loc = sc.next();
					String sql = "INSERT INTO DEPT VALUES (" + deptno + ", '" + dname + "', '" + loc + "')";
					int result = stmt.executeUpdate(sql);
					System.out.println(result > 0 ? "입력성공" : "입력실패");
					break;
				}
			} while (true); // do
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
