package com.lec.ex04update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {
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
			stmt = conn.createStatement();
			System.out.println("������ �μ���ȣ?");
			int deptno = sc.nextInt();
			//	�Է��� �μ���ȣ�� �ִ��� ������ üũ�� ����
			System.out.println("������ �μ���?");
			String dname = sc.next();
			System.out.println("������ ��ġ?");
			String loc = sc.next();
			String sql = "UPDATE DEPT SET DNAME = '"+dname+"', LOC = '"+loc+"' WHERE DEPTNO = "+deptno;
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? "��������" : "�ش�μ��� ���� X");
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
