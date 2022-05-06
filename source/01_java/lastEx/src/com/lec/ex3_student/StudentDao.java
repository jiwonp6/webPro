<<<<<<< HEAD
package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.ex2_person_dtoDao.PersonDto;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static StudentDao INSTANCE; // 싱글톤으로 만들기위해
	public static int SUCCESS = 1; // 가독성 높이기위함
	public static int FAIL = 0;

	// 생성자함수
	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 0번. 전공이름 컴보박스에 추가
	public Vector<String> getMnamelist() {
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT mNAME" + "    FROM MAJORS";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} //
		return mnames;
	}

	// 1번. 학번검색
	public StudentDto sNogetStudent(int sno) {
		int result1 = FAIL;
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE" + "    FROM STUDENT S, MAJORS M"
				+ "    WHERE S.mCODE = M.mCODE AND sNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dto = new StudentDto(0, sno, sname, mname, score);
			} else {
				System.out.println("해당 학번이 존재하지 않습니다.");
			}
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
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}

	// 2번. 이름검색
	public ArrayList<StudentDto> selectSname(String sname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE" + "    FROM STUDENT S, MAJORS M"
				+ "    WHERE S.mCODE = M.mCODE AND sNAME = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sno = rs.getInt("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(0, sno, sname, mname, score));
			}
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
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 3번. 전공검색
	public ArrayList<StudentDto> selectMname(String mname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE" + "    FROM STUDENT S, MAJORS M"
				+ "    WHERE S.mCODE = M.mCODE AND mNAME = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sno = rs.getInt("sno");
				String sname = rs.getString("sname");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(0, sno, sname, mname, score));
			}
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
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 4번. 학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')), ?," + 
				"    (select mcode from majors where mname=?), ?, 0)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 5번. 학생수정
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET sNAME = ?, SCORE=?, mCode = (SELECT mCode FROM MAJORS WHERE mNAME = ?) WHERE sNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getScore());
			pstmt.setString(3, dto.getMname());
			pstmt.setInt(4, dto.getSno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 6번. 학생 출력
	public ArrayList<StudentDto> selectAll() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM \"RANK\", R.*"
				+ "    FROM (SELECT sNAME||'('||sNO||')' sNAME, mNAME||'('||S.mCODE||')' mNAME, SCORE FROM STUDENT S, MAJORS M WHERE S.mCODE = M.mCODE ORDER BY SCORE DESC) R";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentDto dto = new StudentDto(); // dto를 while문 안에 선언해줘야한다!
				dto.setRank(rs.getInt("rank"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 7번. 제적자 출력
	public ArrayList<StudentDto> selectsexpel() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE" + "    FROM STUDENT S, MAJORS M"
				+ "    WHERE S.mCODE = M.mCODE AND sexpel=1";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setSno(rs.getInt("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 8번. 제적처리
	public int expelupdateStudent(int sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SEXPEL = 1 WHERE sNO =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

}
=======
package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.ex2_person_dtoDao.PersonDto;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static StudentDao INSTANCE; // 싱글톤으로 만들기위해
	public static int SUCCESS = 1; // 가독성 높이기위함
	public static int FAIL = 0;

	// 생성자함수
	public StudentDao StudentDao() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1번. 학번검색
	public StudentDto sNogetStudent(int sno) {
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE" + "    FROM STUDENT S, MAJORS M"
				+ "    WHERE S.mCODE = M.mCODE AND sNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dto = new StudentDto(sno, sname, mname, score);
			}else {
				System.out.println("해당 학번이 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 2번. 이름검색
	public ArrayList<StudentDto> selectSname(String sname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE" + "    FROM STUDENT S, MAJORS M"
				+ "    WHERE S.mCODE = M.mCODE AND sNAME = ?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			int sno = rs.getInt("sno");
			String mname = rs.getString("mname");
			int score = rs.getInt("score");
			dtos.add(new StudentDto(sno, sname, mname, score));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 3번. 전공검색
	public ArrayList<StudentDto> selectMname(String mname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE" + "    FROM STUDENT S, MAJORS M"
				+ "    WHERE S.mCODE = M.mCODE AND sNAME = ?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			int sno = rs.getInt("sno");
			String sname = rs.getString("sname");
			int score = rs.getInt("score");
			dtos.add(new StudentDto(sno, sname, mname, score));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	
	// 4번. 학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')), ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getMcode());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getSexpel());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 5번. 학생수정
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET sNAME = ?, SCORE=?, mNO = (SELECT mNO FROM MAJORS WHERE mNAME = ?) WHERE sNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getScore());
			pstmt.setString(3, dto.getMname());
			pstmt.setInt(4, dto.getSno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 6번. 학생 출력
	public ArrayList<StudentDto> selectAll(){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM \"RANK\", R.*" + 
				"    FROM (SELECT sNAME||'('||sNO||')' sNAME, mNAME||'('||S.mCODE||')' mNAME, SCORE FROM STUDENT S, MAJORS M WHERE S.mCODE = M.mCODE ORDER BY SCORE DESC) R";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentDto dto = new StudentDto();	//dto를 while문 안에 선언해줘야한다!
				dto.setRank(rs.getInt("rank"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 7번. 제적자 출력
	public ArrayList<StudentDto> selectsexpel(int sexpel){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql =  "SELECT sNO, sNAME, mNAME, SCORE" + 
				"    FROM STUDENT S, MAJORS M" + 
				"    WHERE S.mCODE = M.mCODE AND sexpel=1";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setSno(rs.getInt("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	
	// 8번. 제적처리
	public int expelupdateStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SEXPEL = 1 WHERE sNO =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	
	
	
	
	
	
}
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
