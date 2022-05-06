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
		//추가할 데이터 받기
		System.out.println("추가할 부서번호?");
		int deptno = sc.nextInt();
		System.out.println("추가할 부서명?");
		String dname = sc.next();
		System.out.println("추가할 부서위치?");
		String loc = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);	//SQL전송객체
			//stmt = conn.createStatement();
			pstmt.setInt(1, deptno);	//sql의 첫번째 물음표에 int값으로 deptno를 setting
			pstmt.setString(2, dname);	//sql의 두번째 물음표에 String값으로 dname을 setting
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();	//삽입되면 result결과가 숫자로 나옴
			//int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? deptno+"번 입력성공" : "입력 실패");
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
