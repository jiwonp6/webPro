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
			System.out.println("������ �Է� : 1, ������ ��ȸ : 2 (�׸� : 0)");
			int ans = sc.nextInt();
			if (ans == 1) {
				System.out.println("�������Է�");
				System.out.println("�̸� : ");
				String pname = sc.next();
				System.out.println("���� : ");
				String jname = sc.next();
				System.out.println("�������� : ");
				String kor = sc.next();
				System.out.println("�������� : ");
				String eng = sc.next();
				System.out.println("�������� : ");
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
					System.out.println(result > 0 ? "�Է¼���" : "�Է½���");

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
				System.out.println("�������Է�");
				System.out.println("��������ȸ) ���� : ");
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
					if (rs.next()) { // �ش�μ� ����
						System.out.println("���\t�̸�(pNO)\t\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							int pno = rs.getInt("pno");
							jname = rs.getString("jname");
							String kor = rs.getString("kor");
							String eng = rs.getString("eng");
							String mat = rs.getString("mat");
							int sumgrade = rs.getInt("sumgrade");
							System.out.println(rank + "��\t" + pname + "(" + pno + "��)" + "\t" + jname + "\t" + kor
									+ "\t" + eng + "\t" + mat + "\t" + sumgrade);
						} while (rs.next());
						break;
					} else { // �ش�μ� ����
						System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
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
				System.out.println("������ �� ���� �۾��Դϴ�.");
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
			System.out.println("������ �Է� : 1, ������ ��ȸ : 2 (�׸� : 0)");
			int ans = sc.nextInt();
			if (ans == 1) {
				System.out.println("�������Է�");
				System.out.println("�̸� : ");
				String pname = sc.next();
				System.out.println("���� : ");
				String jname = sc.next();
				System.out.println("�������� : ");
				String kor = sc.next();
				System.out.println("�������� : ");
				String eng = sc.next();
				System.out.println("�������� : ");
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
					System.out.println(result > 0 ? "�Է¼���" : "�Է½���");

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
				System.out.println("�������Է�");
				System.out.println("��������ȸ) ���� : ");
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
					if (rs.next()) { // �ش�μ� ����
						System.out.println("���\t�̸�(pNO)\t\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							int pno = rs.getInt("pno");
							jname = rs.getString("jname");
							String kor = rs.getString("kor");
							String eng = rs.getString("eng");
							String mat = rs.getString("mat");
							int sumgrade = rs.getInt("sumgrade");
							System.out.println(rank + "��\t" + pname + "(" + pno + "��)" + "\t" + jname + "\t" + kor
									+ "\t" + eng + "\t" + mat + "\t" + sumgrade);
						} while (rs.next());
						break;
					} else { // �ش�μ� ����
						System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
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
				System.out.println("������ �� ���� �۾��Դϴ�.");
			}
		} while (true);
	}

}
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
