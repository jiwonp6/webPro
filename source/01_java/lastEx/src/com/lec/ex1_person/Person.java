<<<<<<< HEAD
package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("데이터 입력 : 1, 직업별 조회 : 2 (그만 : 0)");
			int ans = sc.nextInt();
			if (ans == 1) {
				System.out.println("데이터입력");
				System.out.println("이름 : ");
				String pname = sc.next();
				System.out.println("직업 : ");
				String jname = sc.next();
				System.out.println("국어점수 : ");
				String kor = sc.next();
				System.out.println("영어점수 : ");
				String eng = sc.next();
				System.out.println("수학점수 : ");
				String mat = sc.next();

				String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";

				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setString(3, kor);
					pstmt.setString(4, eng);
					pstmt.setString(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "입력성공" : "입력실패");

				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
					}
				}
			} else if (ans == 2) {
				System.out.println("데이터입력");
				System.out.println("직업별조회) 직업 : ");
				String jname = sc.next();
				String sql2 = "SELECT ROWNUM \"RANK\", SG.*"
						+ "    FROM (SELECT  pNAME, pNo, jNAME, KOR, ENG, MAT, KOR+ENG+MAT SUMGRADE"
						+ "            FROM PERSON P, JOB J \r\n" + "            WHERE P.jNO = J.jNO AND jNAME = ?"
						+ "            ORDER BY SUMGRADE DESC) SG";

				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if (rs.next()) { // 해당부서 존재
						System.out.println("등수\t이름(pNO)\t\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							int pno = rs.getInt("pno");
							jname = rs.getString("jname");
							String kor = rs.getString("kor");
							String eng = rs.getString("eng");
							String mat = rs.getString("mat");
							int sumgrade = rs.getInt("sumgrade");
							System.out.println(rank + "등\t" + pname + "(" + pno + "번)" + "\t" + jname + "\t" + kor
									+ "\t" + eng + "\t" + mat + "\t" + sumgrade);
						} while (rs.next());
						break;
					} else { // 해당부서 없음
						System.out.println("해당 직업이 존재하지 않습니다.");
					}

				} catch (SQLException e) {
					System.out.println("1" + e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println("2" + e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {}
				}
			} else if (ans == 0) {
				break;
			} else {
				System.out.println("수행할 수 없는 작업입니다.");
			}
		} while (true);
	}

}
=======
package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("데이터 입력 : 1, 직업별 조회 : 2 (그만 : 0)");
			int ans = sc.nextInt();
			if (ans == 1) {
				System.out.println("데이터입력");
				System.out.println("이름 : ");
				String pname = sc.next();
				System.out.println("직업 : ");
				String jname = sc.next();
				System.out.println("국어점수 : ");
				String kor = sc.next();
				System.out.println("영어점수 : ");
				String eng = sc.next();
				System.out.println("수학점수 : ");
				String mat = sc.next();

				String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";

				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setString(3, kor);
					pstmt.setString(4, eng);
					pstmt.setString(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "입력성공" : "입력실패");

				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
					}
				}
			} else if (ans == 2) {
				System.out.println("데이터입력");
				System.out.println("직업별조회) 직업 : ");
				String jname = sc.next();
				String sql2 = "SELECT ROWNUM \"RANK\", SG.*"
						+ "    FROM (SELECT  pNAME, pNo, jNAME, KOR, ENG, MAT, KOR+ENG+MAT SUMGRADE"
						+ "            FROM PERSON P, JOB J \r\n" + "            WHERE P.jNO = J.jNO AND jNAME = ?"
						+ "            ORDER BY SUMGRADE DESC) SG";

				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if (rs.next()) { // 해당부서 존재
						System.out.println("등수\t이름(pNO)\t\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							int pno = rs.getInt("pno");
							jname = rs.getString("jname");
							String kor = rs.getString("kor");
							String eng = rs.getString("eng");
							String mat = rs.getString("mat");
							int sumgrade = rs.getInt("sumgrade");
							System.out.println(rank + "등\t" + pname + "(" + pno + "번)" + "\t" + jname + "\t" + kor
									+ "\t" + eng + "\t" + mat + "\t" + sumgrade);
						} while (rs.next());
						break;
					} else { // 해당부서 없음
						System.out.println("해당 직업이 존재하지 않습니다.");
					}

				} catch (SQLException e) {
					System.out.println("1" + e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println("2" + e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {}
				}
			} else if (ans == 0) {
				break;
			} else {
				System.out.println("수행할 수 없는 작업입니다.");
			}
		} while (true);
	}

}
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
