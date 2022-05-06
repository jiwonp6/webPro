package com.lec.ex06preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
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
			do {  // ���߳� �ڹ�����
				// ���߳� �ڹ�����
				// ���߳� �ڹ�����
				// ���߳� �ڹ�����
				// ���߳� �ڹ�����
				// ���߳� �ڹ�����
				// ���߳� �ڹ�����
				// ���߳� �ڹ�����
				
				System.out.println("ã�� �μ���?");
				String dname = sc.next();
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql); // SQL���۰�ü
				pstmt.setString(1, dname); // sql�� ù��° ����ǥ�� dname setting
				rs = pstmt.executeQuery();	//()�ȿ� sql���� �ȵ�, �̹� ������

				if (rs.next()) { // �ش�μ� ����
					System.out.println("���\t�����\t��å\t\t�޿�");
					do {
						String job = rs.getString("job");
						if (job.length() < 8 && job!=null) {
							job = job + "\t";
						}
						System.out.print(rs.getInt("empno") + "\t" + rs.getString("ename") + "\t" + job + "\t"
								+ rs.getInt("sal") + "\n");

					} while (rs.next());
					break;
				} else { // �ش�μ� ����
					System.out.println(dname + "�μ��� �������� �ʽ��ϴ�.");
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
