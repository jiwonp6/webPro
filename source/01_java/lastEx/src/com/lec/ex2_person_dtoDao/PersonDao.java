<<<<<<< HEAD
package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

//입력, 직업별조회, 전체조회, 직업리스트
public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static PersonDao INSTANCE;	//싱글톤으로 만들기위해
	public static int SUCCESS = 1;	//가독성 높이기위함
	public static int FAIL = 0;
	//생성자함수
	public static PersonDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	private PersonDao() {
		try {
			Class.forName(driver);	//1단계는 생성자에서 한 번
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
//★ 1번 입력 (매개변수 dto, return SUCCESS/FAIL)	 -> 0/1로 result반환
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		//dto안의 값을 DB에 insert(2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
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
	
//★ 2번 직업별 조회(매개변수 jname, return PersonDto arraylist) ->arraylist이용 -> dtos로 묶어서 하나로 result값 반환
	public ArrayList<PersonDto> selectJname(String jname){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		//직업별조회 결과를 dtos에 add(2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM \"RANK\", SG.*" + 
					"    FROM (SELECT  pNAME||'('||pNO||'번)' pname, jNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
					"            FROM PERSON P, JOB J " + 
					"            WHERE P.jNO = J.jNO AND jNAME = ? " + 
					"            ORDER BY SUM DESC) SG";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
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
		return dtos;
	}
	
//★ 3번 전체조회(매개변수X, retrun ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		//전체조회 결과를 dtos에 add(2~7단계)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	//select문에는 반드시 필요
		String sql = "SELECT ROWNUM RANK, A.*" + 
					"    FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
					"            FROM PERSON P, JOB J" + 
					"            WHERE P.JNO=J.JNO " + 
					"            ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PersonDto dto = new PersonDto();	//dto를 while문 안에 선언해줘야한다!
				dto.setRank(rs.getInt("rank"));
				dto.setPname(rs.getString("pname"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
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
	
//★ 4번 직업리스트조회(return Vector<String>)
	public Vector<String> jnamelist(){
		Vector<String> jnames = new Vector<String>();
		jnames.add("");	//0번째 인덱스에는 빈스트링!(jname을 1번부터 나오도록 하기위함)
		//직업명리스트를 DB에서 검색한 후 jname에 add(2~7단계)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
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
		}	//
		return jnames;
		
	}	//jnamelist
	
}	//class
=======
package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

//입력, 직업별조회, 전체조회, 직업리스트
public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static PersonDao INSTANCE;	//싱글톤으로 만들기위해
	public static int SUCCESS = 1;	//가독성 높이기위함
	public static int FAIL = 0;
	//생성자함수
	public static PersonDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	private PersonDao() {
		try {
			Class.forName(driver);	//1단계는 생성자에서 한 번
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
//★ 1번 입력 (매개변수 dto, return SUCCESS/FAIL)	 -> 0/1로 result반환
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		//dto안의 값을 DB에 insert(2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
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
	
//★ 2번 직업별 조회(매개변수 jname, return PersonDto arraylist) ->arraylist이용 -> dtos로 묶어서 하나로 result값 반환
	public ArrayList<PersonDto> selectJname(String jname){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		//직업별조회 결과를 dtos에 add(2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM \"RANK\", SG.*" + 
					"    FROM (SELECT  pNAME||'('||pNO||'번)' pname, jNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
					"            FROM PERSON P, JOB J " + 
					"            WHERE P.jNO = J.jNO AND jNAME = ? " + 
					"            ORDER BY SUM DESC) SG";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
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
		return dtos;
	}
	
//★ 3번 전체조회(매개변수X, retrun ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		//전체조회 결과를 dtos에 add(2~7단계)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	//select문에는 반드시 필요
		String sql = "SELECT ROWNUM RANK, A.*" + 
					"    FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
					"            FROM PERSON P, JOB J" + 
					"            WHERE P.JNO=J.JNO " + 
					"            ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PersonDto dto = new PersonDto();	//dto를 while문 안에 선언해줘야한다!
				dto.setRank(rs.getInt("rank"));
				dto.setPname(rs.getString("pname"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
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
	
//★ 4번 직업리스트조회(return Vector<String>)
	public Vector<String> jnamelist(){
		Vector<String> jnames = new Vector<String>();
		jnames.add("");	//0번째 인덱스에는 빈스트링!(jname을 1번부터 나오도록 하기위함)
		//직업명리스트를 DB에서 검색한 후 jname에 add(2~7단계)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
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
		}	//
		return jnames;
		
	}	//jnamelist
	
}	//class
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
