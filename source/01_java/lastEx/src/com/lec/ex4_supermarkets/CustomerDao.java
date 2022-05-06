<<<<<<< HEAD
package com.lec.ex4_supermarkets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1; // ������ ���̱�����
	public static final int FAIL = 0;
	private static CustomerDao INSTANCE;

	public static CustomerDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}
	// => private static CustomerDao INSTANCE = new CustomerDao();
	// public static CustomerDao getInstance() {
	// return INSTANCE;
	// }
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//0.�����̸� �˻�
	public Vector<String> getLevelNames() {
		Vector<String> levelNames = new Vector<String>();
		levelNames.add(""); // ��Ʈ���߰�
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				levelNames.add(rs.getString("levelname"));
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
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return levelNames;
	}
	//1.���̵�˻� 
	public CustomerDto cIdGetCustomer(int cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, "
				+ "        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP"
				+ "    FROM CUSTOMER C, CUS_LEVEL L" + "    WHERE C.LEVELNO = L.LEVELNO AND cID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelup = rs.getInt("forLevelup");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelup);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dto;
	}
	//2.�� ������4�ڸ��˻�(full�� ����) 
	public ArrayList<CustomerDto> cTelGetCustomer(String ctel){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND cTEL LIKE '%'||?" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//3.���̸��˻� 
	ArrayList<CustomerDto> cNameGetCustomer(String cname){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND cNAME = ?" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//4.����Ʈ�θ� ����
	public int buyWithPoint(int cid, int camount) {
		int result = FAIL;	//�־��� �������� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
				"    SET cPOINT = cPOINT-? " + 
				"    WHERE cID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//5.��ǰ���� 
	public int buy(int cid, int camount) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER\r\n" + 
				"    SET cPOINT = cPOINT + (?*0.05)," + 
				"        cAMOUNT = cAMOUNT + ?," + 
				"        LEVELNO = (SELECT L.LEVELNO " + 
				"                    FROM CUSTOMER C, CUS_LEVEL L " + 
				"                    WHERE cAMOUNT + ? BETWEEN LOW AND HIGH AND cID=?)" + 
				"    WHERE cID =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//6.��޺���� 
	ArrayList<CustomerDto> levelNameGetCustomer(String levelname){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = ?" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//7.��ü��� 
	ArrayList<CustomerDto> getCustomers(){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//8.ȸ������ 
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (cID, cTEL, cNAME) VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//9.��ȣ���� 
	public int updateCustomer(int cid, String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
				"    SET cTEL =?" + 
				"    WHERE cID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//10.ȸ��Ż�� 
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE " + 
				"    FROM CUSTOMER" + 
				"    WHERE cTEL = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
}
=======
package com.lec.ex4_supermarkets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1; // ������ ���̱�����
	public static final int FAIL = 0;
	private static CustomerDao INSTANCE;

	public static CustomerDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}
	// => private static CustomerDao INSTANCE = new CustomerDao();
	// public static CustomerDao getInstance() {
	// return INSTANCE;
	// }
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//0.�����̸� �˻�
	public Vector<String> getLevelNames() {
		Vector<String> levelNames = new Vector<String>();
		levelNames.add(""); // ��Ʈ���߰�
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				levelNames.add(rs.getString("levelname"));
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
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return levelNames;
	}
	//1.���̵�˻� 
	public CustomerDto cIdGetCustomer(int cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, "
				+ "        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP"
				+ "    FROM CUSTOMER C, CUS_LEVEL L" + "    WHERE C.LEVELNO = L.LEVELNO AND cID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelup = rs.getInt("forLevelup");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelup);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dto;
	}
	//2.�� ������4�ڸ��˻�(full�� ����) 
	public ArrayList<CustomerDto> cTelGetCustomer(String ctel){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND cTEL LIKE '%'||?" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//3.���̸��˻� 
	ArrayList<CustomerDto> cNameGetCustomer(String cname){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND cNAME = ?" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//4.����Ʈ�θ� ����
	public int buyWithPoint(int cid, int camount) {
		int result = FAIL;	//�־��� �������� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
				"    SET cPOINT = cPOINT-? " + 
				"    WHERE cID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//5.��ǰ���� 
	public int buy(int cid, int camount) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER\r\n" + 
				"    SET cPOINT = cPOINT + (?*0.05)," + 
				"        cAMOUNT = cAMOUNT + ?," + 
				"        LEVELNO = (SELECT L.LEVELNO " + 
				"                    FROM CUSTOMER C, CUS_LEVEL L " + 
				"                    WHERE cAMOUNT + ? BETWEEN LOW AND HIGH AND cID=?)" + 
				"    WHERE cID =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//6.��޺���� 
	ArrayList<CustomerDto> levelNameGetCustomer(String levelname){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = ?" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//7.��ü��� 
	ArrayList<CustomerDto> getCustomers(){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO" + 
				"    ORDER BY cAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forLevelup = rs.getInt("forLevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forLevelup)) ;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	//8.ȸ������ 
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (cID, cTEL, cNAME) VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//9.��ȣ���� 
	public int updateCustomer(int cid, String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
				"    SET cTEL =?" + 
				"    WHERE cID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//10.ȸ��Ż�� 
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE " + 
				"    FROM CUSTOMER" + 
				"    WHERE cTEL = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
}
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
