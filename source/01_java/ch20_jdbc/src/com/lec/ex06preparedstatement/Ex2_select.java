package com.lec.ex06preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오
public class Ex2_select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + "    FROM EMP E, DEPT D\r\n"
				+ "    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER(?)";
		try {
			do {  // 잘했네 박박지원
				// 잘했네 박박지원
				// 잘했네 박박지원
				// 잘했네 박박지원
				// 잘했네 박박지원
				// 잘했네 박박지원
				// 잘했네 박박지원
				// 잘했네 박박지원
				
				System.out.println("찾는 부서명?");
				String dname = sc.next();
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql); // SQL전송객체
				pstmt.setString(1, dname); // sql의 첫번째 물음표에 dname setting
				rs = pstmt.executeQuery();	//()안에 sql들어가면 안됨, 이미 들어가있음

				if (rs.next()) { // 해당부서 존재
					System.out.println("사번\t사원명\t직책\t\t급여");
					do {
						String job = rs.getString("job");
						if (job.length() < 8 && job!=null) {
							job = job + "\t";
						}
						System.out.print(rs.getInt("empno") + "\t" + rs.getString("ename") + "\t" + job + "\t"
								+ rs.getInt("sal") + "\n");

					} while (rs.next());
					break;
				} else { // 해당부서 없음
					System.out.println(dname + "부서는 존재하지 않습니다.");
				}
			} while (true);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
