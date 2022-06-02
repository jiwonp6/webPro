package com.lec.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FriendDao {
	public static final int SUCCESS = 1;	//친구 추가 성공
	public static final int FAIL = 0;	//친구 추가 실패
	
	private static FriendDao instance;
	public static FriendDao getInstance() {
		if(instance == null) {
			instance = new FriendDao();
		}
		return instance;
	}
	//생성자
	private FriendDao() {}
	//conn객체 리턴 (→ 커넥션풀 사용X)
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "scott", "tiger");
		return conn;
	}
	// 1. 모든 친구 뿌리기(select문)
	public ArrayList<FriendDto> getFriend() {
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql= "SELECT * FROM FRIEND";
		try {
			conn= getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				dtos.add(new FriendDto(num, name, phone1, phone2, phone3));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
		return dtos;
	}
	// 2. 친구 추가(insert문)
	public int joinFriend(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT" + 
				"    INTO FRIEND (NUM, NAME, PHONE1, PHONE2, PHONE3)" + 
				"    VALUES(FRIEND_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone1());
			pstmt.setString(3, dto.getPhone2());
			pstmt.setString(4, dto.getPhone3());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("친구추가 실패..ㅠ");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
		return result;
	}
	//3. 친구 찾기
	public ArrayList<FriendDto> findFriend(String name, String phone1, String phone2, String phone3) {
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= "SELECT * FROM FRIEND" + 
				"    WHERE NAME LIKE '%'||?||'%' AND PHONE1 LIKE '%'||?||'%' AND PHONE2 LIKE '%'||?||'%' AND PHONE3 LIKE '%'||?||'%' ";
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone1);
			pstmt.setString(3, phone2);
			pstmt.setString(4, phone3);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				name = rs.getString("name");
				phone1 = rs.getString("phone1");
				phone2 = rs.getString("phone2");
				phone3 = rs.getString("phone3");
				dtos.add(new FriendDto(num, name, phone1, phone2, phone3));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
		return dtos;
	}
}
