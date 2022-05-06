package com.lec.ex05delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//사용자로부터 삭제하고자 하는 부서번호를 입력받아 삭제하기
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 부서번호는?");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;
		try {
			Class.forName(driver);	//드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger");	//드라이버 로그인
			stmt = conn.createStatement();	//sql문 전송 객체
			int result = stmt.executeUpdate(sql);	//결과값 받기
			System.out.println(result>0 ? deptno+"번 삭제성공" : deptno+"번 부서는 존재하지않습니다");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류 : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류 : "+e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
