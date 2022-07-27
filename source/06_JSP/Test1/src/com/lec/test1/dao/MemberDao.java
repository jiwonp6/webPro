package com.lec.test1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.test1.dto.MemberDto;
import com.lec.test1.dto.SalesListDto;

public class MemberDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	//싱글톤
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe", "scott", "tiger");
		return con;
	}
	//1. memberList
	public ArrayList<MemberDto> memberList(){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				dtos.add(new MemberDto(custno, custname, phone, address, joindate, grade, city));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return dtos;
	}
	//2.getMAX_Custno
	public int getMAX_Custno(){
		int max = FAIL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(CUSTNO) MAX FROM MEMBER";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			rs.next();
			max = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return max;
	}
	//3.joinMember
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT " + 
				"        INTO MEMBER(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY)" + 
				"        VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ? )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustname());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setDate(4, dto.getJoindate());
			pstmt.setString(5, dto.getGrade());
			pstmt.setString(6, dto.getCity());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
		return result;
	}
	//4.getMemberDto
	public MemberDto getMember(int custno) {
		MemberDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE CUSTNO = ?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				dto = new MemberDto(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) { }
		}
		return dto;
	}
	//5.modifyMember
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET CUSTNAME = ?," + 
				"                      PHONE = ?," + 
				"                      ADDRESS = ?," + 
				"                      JOINDATE = ?," + 
				"                      GRADE = ?," + 
				"                      CITY = ?" + 
				"                  WHERE CUSTNO = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustname());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setDate(4, dto.getJoindate());
			pstmt.setString(5, dto.getGrade());
			pstmt.setString(6, dto.getCity());
			pstmt.setInt(7, dto.getCustno());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
		return result;
	}
	//6.memberSalesList
	public ArrayList<SalesListDto> memberSalesList(){
		ArrayList<SalesListDto> dtos = new ArrayList<SalesListDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT M.CUSTNO, M.CUSTNAME, G.GNAME, SUM(MONEY.PRICE) SUM" + 
				"        FROM MEMBER M, GRADE G, MONEY MONEY" + 
				"        WHERE M.GRADE = G.GRADE AND MONEY.CUSTNO = M.CUSTNO" + 
				"        GROUP BY M.CUSTNO, M.CUSTNAME, G.GNAME" + 
				"        ORDER BY SUM DESC";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String gname = rs.getString("gname");
				int sum = rs.getInt("sum");
				dtos.add(new SalesListDto(custno, custname, gname, sum));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return dtos;
	}
	//7.productSalesList
	public ArrayList<SalesListDto> productSalesList(){
		ArrayList<SalesListDto> dtos = new ArrayList<SalesListDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT PCODE, SUM(PRICE) SUM" + 
				"        FROM MONEY " + 
				"        GROUP BY PCODE" + 
				"        ORDER BY SUM DESC";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				int sum = rs.getInt("sum");
				dtos.add(new SalesListDto(pcode, sum));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return dtos;
	}
	
}
