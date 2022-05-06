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
				System.out.println("�Է��� �μ���ȣ�� ?");
				int deptno = sc.nextInt();
				String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectSQL);
				if (rs.next()) {
					System.out.println("�̹� �����ϴ� �μ���ȣ �Դϴ�.");
				} else {
					System.out.println("�Է��� �μ����� ?");
					String dname = sc.next();
					System.out.println("�Է��� �μ� ��ġ��?");
					String loc = sc.next();
					String sql = "INSERT INTO DEPT VALUES (" + deptno + ", '" + dname + "', '" + loc + "')";
					int result = stmt.executeUpdate(sql);
					System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
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
