package com.lec.ex02selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. ����ڿ��� �μ����� �Է¹޾�
 * 1-1. �μ������ϴ� ��� : �μ������� �������(���, �̸�, �޿�, �޿����)�� ���  
 * 1-2. �μ��������� �ʴ� ��� : ���ٰ� ���
 */
public class Ex3_selectDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ� �μ�����?");
		String dname = sc.next();
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('"+dname+"')";
		// => sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname);
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE" + 
				"    FROM EMP E, SALGRADE, DEPT D\r\n" + 
				"    WHERE E.SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO = D.DEPTNO AND DNAME = UPPER('%s')", dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {	//������ true ��ȯ
				System.out.println("�μ���ȣ : "+rs.getInt("deptno"));
				System.out.println("�μ��̸� : "+rs.getString("dname"));
				System.out.println("�μ���ġ : "+rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {	//�ش�μ����� ����� �ִ� ��� -> while�� ���� ���� �ȳ����°�� �� �ȳ������� ����
					do {	//EMPNO, ENAME, SAL, GRADE
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+grade+"���");
					}while(rs.next());
				}else {	//�ش�μ����� ����� ���°��
					System.out.println(dname + "�μ��� ����� �������� �ʽ��ϴ�.");
				}
			}else {
				System.out.println("�ش� �μ��̸��� ��ȿ���� �ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		
	
	
	
	}
}
