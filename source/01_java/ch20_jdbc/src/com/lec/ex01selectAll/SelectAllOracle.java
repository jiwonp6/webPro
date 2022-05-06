package com.lec.ex01selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;	//DB ���� ��ü ����
		Statement stmt = null;	//SQL ���� ��ü ����
		ResultSet rs = null;	//SELECT�� ��� �޴� ��ü ����
		String query = "SELECT * FROM EMP";
		
		try {
			//1. ����̹� �ε�
			Class.forName(driver);
			//2. DB ����
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//3. SQL ���� ��ü ����
			stmt = conn.createStatement();
			//4. SQL ���� + 5. SQL ���� ��� �ޱ�
			rs = stmt.executeQuery(query);
			//6. ��� �޾� ���ϴ� ���� ����(����� rs�� ����)
			System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ");
			while(rs.next()) {	//rs�� �Ǹ������� ����Ű�� false��ȯ
				int empno = rs.getInt("empno");	//Ư������ ���� sql���� ���̹� �ʿ���
				String ename = rs.getString("ename");	//int���� String���� �������� String������ �ٲ� ������ ��
				String job = rs.getString("job");
				if(job.length()<6) {
					job = job+"\t";
				}
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				// = String hiredate = rs.getString("hiredate");	String���� �������� �ð����� ����
				// = Timestamp hiredate = rs.getTimestamp("hiredate");	 String�̶� ���
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
						empno, ename, job, mgr, hiredate, sal, comm, deptno);	// TF�� ������ timestamp�� �޾Ƽ� ���� �ð� �ȳ���
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	//7. ���� ����
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
