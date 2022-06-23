package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.AdminDto;
import com.lec.dto.Mvc_MemberDto;

public class AdminDao {
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	public final static int NONEXISTENT = 1;
	public final static int EXISTENT = 0;
	private DataSource ds; // null값으로 초기화 돼있음
	// 싱글톤
	private static AdminDao instance = new AdminDao();

	public static AdminDao getInstance() {
		return instance;
	}

	private AdminDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	// (1)로그인
	public int login(String aid, String apw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ADMIN WHERE aID = ? AND aPW = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			pstmt.setString(2, apw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = SUCCESS;
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
		return result;
	}

	// (2)aID로 DTO 가져오기(로그인 성공시 SESSION에 넣기 위함)
	public AdminDto modifyView_replyView(String aid) {
		AdminDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ADMIN WHERE aID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String apw = rs.getString("mpw");
				String aname = rs.getString("mname");
				dto = new AdminDto(aid, apw, aname);
			}
			System.out.println("id로 가져온 dto : " + dto);
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
}
