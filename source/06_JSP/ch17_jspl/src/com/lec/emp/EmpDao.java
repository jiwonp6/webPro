package com.lec.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDao {
	//Connection 객체 얻어오는 함수
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	//1. 전체 list
	public ArrayList<EmpDto> listEmp() {
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT EMPNO, ENAME, JOB, NVL(MGR, 0) MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO" + 
				"    FROM EMP";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno =rs.getInt("empno");
				String ename =rs.getString("ename");
				String job =rs.getString("job");
				int mgr =rs.getInt("mgr");
				Timestamp hiredate =rs.getTimestamp("hiredate");
				int sal =rs.getInt("sal");
				int comm =rs.getInt("comm");
				int deptno =rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return emps;
	}
	//2. 검색
	public ArrayList<EmpDto> searchEmp(String schName, String schJob) {
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT EMPNO, ENAME, JOB, NVL(MGR, 0) MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO FROM EMP" + 
				"    WHERE ENAME LIKE '%'||UPPER(?)||'%'\r\n" + 
				"        AND JOB LIKE '%'||UPPER(?)||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			pstmt.setString(2, schJob);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno =rs.getInt("empno");
				String ename =rs.getString("ename");
				String job =rs.getString("job");
				int mgr =rs.getInt("mgr");
				Timestamp hiredate =rs.getTimestamp("hiredate");
				int sal =rs.getInt("sal");
				int comm =rs.getInt("comm");
				int deptno =rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return emps;
	}
}
