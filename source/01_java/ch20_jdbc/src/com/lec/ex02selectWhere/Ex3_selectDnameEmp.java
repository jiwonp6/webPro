package com.lec.ex02selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. 사용자에게 부서명을 입력받아
 * 1-1. 부서존재하는 경우 : 부서정보와 사원정보(사번, 이름, 급여, 급여등급)를 출력  
 * 1-2. 부서존재하지 않는 경우 : 없다고 출력
 */
public class Ex3_selectDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 부서명은?");
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
			if(rs.next()) {	//맞으면 true 반환
				System.out.println("부서번호 : "+rs.getInt("deptno"));
				System.out.println("부서이름 : "+rs.getString("dname"));
				System.out.println("부서위치 : "+rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {	//해당부서명의 사원이 있는 경우 -> while을 쓰면 값이 안나오는경우 왜 안나오는지 몰라서
					do {	//EMPNO, ENAME, SAL, GRADE
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+grade+"등급");
					}while(rs.next());
				}else {	//해당부서명의 사원이 없는경우
					System.out.println(dname + "부서의 사원은 존재하지 않습니다.");
				}
			}else {
				System.out.println("해당 부서이름은 유효하지 않습니다.");
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
