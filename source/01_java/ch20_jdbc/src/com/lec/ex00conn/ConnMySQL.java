package com.lec.ex00conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/parkdb?serverTimezone=UTC";
		Connection conn = null;
		try {
			//1. ����̹� �ε�
			Class.forName(driver);
			//2. DB ���� ��ü ����
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("MySQL DB ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
