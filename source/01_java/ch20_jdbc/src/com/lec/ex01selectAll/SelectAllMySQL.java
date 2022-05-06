package com.lec.ex01selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/parkdb?serverTimezone=UTC";
		String sql = "SELECT * FROM PERSONAL";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. 
			Class.forName(driver);
			//2.
			conn = DriverManager.getConnection(url, "root", "mysql");
			//3.
			stmt = conn.createStatement();
			//4. + 5.
			rs = stmt.executeQuery(sql);
			//6.
			if(rs.next()) {	//SELECT�� ����� �ִ� ���
				System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ");
				do {	//while�� �����ϸ� ���� ó�� �� ���� ����
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					
					System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
				}while(rs.next());
			}else {	//SELECT�� ����� �� �൵ ���� ���
				System.out.println("Personal �����Ͱ� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	//7. ���� ����
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		
	}
}
