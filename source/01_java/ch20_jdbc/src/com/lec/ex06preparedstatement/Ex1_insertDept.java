package com.lec.ex06preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex1_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		//�߰��� ������ �ޱ�
		System.out.println("�߰��� �μ���ȣ?");
		int deptno = sc.nextInt();
		System.out.println("�߰��� �μ���?");
		String dname = sc.next();
		System.out.println("�߰��� �μ���ġ?");
		String loc = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);	//SQL���۰�ü
			//stmt = conn.createStatement();
			pstmt.setInt(1, deptno);	//sql�� ù��° ����ǥ�� int������ deptno�� setting
			pstmt.setString(2, dname);	//sql�� �ι�° ����ǥ�� String������ dname�� setting
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();	//���ԵǸ� result����� ���ڷ� ����
			//int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? deptno+"�� �Է¼���" : "�Է� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	}
}
