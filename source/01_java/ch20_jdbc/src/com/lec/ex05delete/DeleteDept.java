package com.lec.ex05delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//����ڷκ��� �����ϰ��� �ϴ� �μ���ȣ�� �Է¹޾� �����ϱ�
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �μ���ȣ��?");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;
		try {
			Class.forName(driver);	//����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger");	//����̹� �α���
			stmt = conn.createStatement();	//sql�� ���� ��ü
			int result = stmt.executeUpdate(sql);	//����� �ޱ�
			System.out.println(result>0 ? deptno+"�� ��������" : deptno+"�� �μ��� ���������ʽ��ϴ�");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ���� : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL ���� : "+e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
