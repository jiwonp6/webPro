package com.lec.ex03insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է��� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		System.out.println("�Է��� �μ����� ?");
		String dname = sc.next();
		System.out.println("�Է��� �μ� ��ġ��?");
		String loc = sc.next();
		String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
		// sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
			
		} catch (ClassNotFoundException e) {
			System.out.println("SQL���� : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
