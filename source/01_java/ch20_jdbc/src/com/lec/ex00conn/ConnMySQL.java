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
			//1. 드라이버 로드
			Class.forName(driver);
			//2. DB 연결 객체 생성
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("MySQL DB 연결 성공");
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
