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

import com.lec.dto.FileBoardDto;

public class FileBoardDao {
	public static final int SUCCESS = 1; // 회원가입시
	public static final int FAIL = 0; // 회원가입시
	private DataSource ds; // null값으로 초기화 돼있음
	// 싱글톤
	private static FileBoardDao instance = new FileBoardDao();

	public static FileBoardDao getInstance() {
		return instance;
	}

	private FileBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	// 글목록
	public ArrayList<FileBoardDto> listBoard(int startRow, int endRow) {
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *" + "        FROM (SELECT ROWNUM RN, A.*"
				+ "                FROM (SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A)"
				+ "        WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("fid");
				String mid = rs.getString("mid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				dtos.add(new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent,
						fip));
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
			}
		}
		return dtos;
	}

	// 전체갯수
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) fCNT FROM FILEBOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("fCNT");
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
		return totalCnt;
	}

	// 원글쓰기
	public int write(String mid, String ftitle, String fcontent, String ffilename, String fip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)"
				+ "        VALUES ( FBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, FBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, ftitle);
			pstmt.setString(3, fcontent);
			pstmt.setString(4, ffilename);
			pstmt.setString(5, fip);
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
			}
		}
		return result;
	}

	// fid로 조회수 올리기(private)
	private void hitUp(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}

	// fid로 dto가져오기 = 수정하기 + 답변글 쓰기(form, 조회수올리기 미포함)
	public FileBoardDto modifyView_replyView(int fid) {
		FileBoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FILEBOARD WHERE fID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				dto = new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent,
						fip);
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
			}
		}
		return dto;
	}
	// fid로 dto가져오기 = 글상세보기(조회수올리기 포함)
	public FileBoardDto contentView(int fid) {
		FileBoardDto dto = null;
		hitUp(fid); // 글 상세보기 시 자동적으로 hitup
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FILEBOARD WHERE fID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				dto = new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent,
						fip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"content");
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
		return dto;
	}

	// 답변글 쓰기 전 step a
	private void preReplyStep(int fgroup, int fstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET fSTEP = fSTEP+1 WHERE fGROUP=? AND fSTEP>?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}

	// 답글쓰기
	public int reply(String mid, String ftitle, String fcontent, String ffilename, String fip, int fgroup, int fstep,
			int findent) {
		int result = FAIL;
		preReplyStep(fgroup, fstep);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)\r\n"
				+ "        VALUES (FBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, ftitle);
			pstmt.setString(3, fcontent);
			pstmt.setString(4, ffilename);
			pstmt.setInt(5, fgroup);
			pstmt.setInt(6, fstep + 1);
			pstmt.setInt(7, findent + 1);
			pstmt.setString(8, fip);
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
			}
		}
		return result;
	}

	// 글수정
	public int modify(int fid, String mid, String ftitle, String fcontent, String ffilename, String fip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fTITLE = ?," + "                     fCONTENT = ?,"
				+ "                     fFILENAME = ?," + "                     fIP = ?"
				+ "                 WHERE fID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ftitle);
			pstmt.setString(2, fcontent);
			pstmt.setString(3, ffilename);
			pstmt.setString(4, fip);
			pstmt.setInt(5, fid);
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
			}
		}
		return result;
	}

	// 글삭제
	public int delte(int fid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE fID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
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
			}
		}
		return result;
	}
}
