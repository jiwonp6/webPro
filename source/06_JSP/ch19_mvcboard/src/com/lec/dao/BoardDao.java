package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.BoardDto;
import com.lec.dto.MemberDto;

public class BoardDao {
	public static final int SUCCESS = 1; // 회원가입시
	public static final int FAIL = 0;    // 회원가입시
	private DataSource ds;	//null값으로 초기화 돼있음
	// 싱글톤
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	//글목록
	public ArrayList<BoardDto> listBoard(int startRow, int endRow){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT *" + 
				"    FROM (ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid    = rs.getInt("bid");
				String bname  = rs.getString("bname");
				String btitle  = rs.getString("btitle");
				String bcontent  = rs.getString("bcontent");
				Date bdate   = rs.getDate("bdate");
				int bhit    = rs.getInt("bhit");
				int bgroup    = rs.getInt("bgroup");
				int bstep    = rs.getInt("bstep");
				int bindent    = rs.getInt("bindent");
				String bip  = rs.getString("bip");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return dtos;
	}
	//전체갯수
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("CNT");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return totalCnt;
	}
	//원글쓰기
	public int write(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	//bid로 조회수 올리기(private)
	private void hitUp(int bid) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD" + 
				"    SET bHIT = bHIT+1" + 
				"    WHERE bID =?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	//bid로 dto가져오기 = 글상세보기(조회수올리기 포함)
	public BoardDto modifyView_replyView(int bid) {
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOARD WHERE bID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String bname  = rs.getString("bname");
				String btitle  = rs.getString("btitle");
				String bcontent  = rs.getString("bcontent");
				Date bdate   = rs.getDate("bdate");
				int bhit    = rs.getInt("bhit");
				int bgroup    = rs.getInt("bgroup");
				int bstep    = rs.getInt("bstep");
				int bindent    = rs.getInt("bindent");
				String bip  = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		return dto;
	}
	//bid로 dto가져오기 = 수정하기 + 답변글 쓰기(form, 조회수올리기 미포함)
		public BoardDto contentView(int bid) {
			BoardDto dto = null;
			hitUp(bid);	//글 상세보기 시 자동적으로 hitup
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM BOARD WHERE bID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String bname  = rs.getString("bname");
					String btitle  = rs.getString("btitle");
					String bcontent  = rs.getString("bcontent");
					Date bdate   = rs.getDate("bdate");
					int bhit    = rs.getInt("bhit");
					int bgroup    = rs.getInt("bgroup");
					int bstep    = rs.getInt("bstep");
					int bindent    = rs.getInt("bindent");
					String bip  = rs.getString("bip");
					dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs   !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				}catch (SQLException e) {
					// TODO: handle exception
				}
			return dto;
		}
	//답변글 쓰기 전 step a
	private void preReplyStep(int bgroup, int bstep) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET bSTEP = bSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	//답변글 쓰기	-- 답변자 : bname, btitle, bcontent, bip
	//			-- 원  글  : bgroup, bstep, bindent 
	public int reply(String bname, String btitle, String bcontent, String bip, int bgroup, int bstep, int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep);
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)" + 
				"    VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			pstmt.setString(7, bip);
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	//글수정
	public int modify(int bid, String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD " + 
				"    SET BNAME =?," + 
				"        BTITLE =?," + 
				"        BCONTENT = ?," + 
				"        BIP = ?" + 
				"    WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.setInt(5, bid);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	//글삭제
	public int delte(int bid) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
}
