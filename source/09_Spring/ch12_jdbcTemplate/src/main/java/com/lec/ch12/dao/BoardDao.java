package com.lec.ch12.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.ch12.dto.BoardDto;
import com.lec.ch12.util.Constant;

public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public JdbcTemplate template;
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		template = Constant.template;
	}
	// 글목록
	/* public ArrayList<BoardDto> boardList(){
		String sql = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP";
		ArrayList<BoardDto> dtos 
				= (ArrayList<BoardDto>) template.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		return dtos;
	}*/
	public ArrayList<BoardDto> boardList(final int startRow, final int endRow){
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* "
				+ "           FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" 
				+ "		WHERE RN BETWEEN ? AND ?";
		ArrayList<BoardDto> dtos 
				= (ArrayList<BoardDto>) template.query(
						sql, 
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement pstmt) throws SQLException {
								pstmt.setInt(1, startRow);
								pstmt.setInt(2, endRow);
							}
						}, 
						new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		return dtos;
	}
	// 글 갯수 
	public int getBoardTotCnt(){
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		return template.queryForObject(sql, Integer.class);		//sql, sql타입
	}
	//원글쓰기
	public int write(final BoardDto bDto){
		String sql = "INSERT INTO MVC_BOARD "
				+ "(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, " + 
				"            MVC_BOARD_SEQ.CURRVAL, 0,0, ?)";
		return template.update(
						sql, 
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement pstmt) throws SQLException {
								pstmt.setString(1, bDto.getbName());
								pstmt.setString(2, bDto.getbTitle());
								pstmt.setString(3, bDto.getbContent());
								pstmt.setString(4, bDto.getbIp());
							}
						});
	}
	// hit수 올리기
	private void hitUp(int bId) {
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID="+bId;
		template.update(sql);
		
	}
	// 글 상세보기(글 상세볼 때 조회수도 올림)
	public BoardDto contentView(int bId) {
		hitUp(bId);
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bId;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// bid로 dto 가져오기 (답글쓰기 + 수정)
	public BoardDto modifyView_replyView(int bId) {
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bId;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// 글 수정하기
	public int modify(final BoardDto bDto) {
		String sql = "UPDATE MVC_BOARD SET BNAME=?, " + 
				"                    BTITLE = ?, " + 
				"                    BCONTENT = ?, " + 
				"                    BIP = ?" + 
				"        WHERE BID=?";
		return template.update(sql,
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement pstmt) throws SQLException {
								pstmt.setString(1, bDto.getbName());
								pstmt.setString(2, bDto.getbTitle());
								pstmt.setString(3, bDto.getbContent());
								pstmt.setString(4, bDto.getbIp());
								pstmt.setInt(5, bDto.getbId());
							}
						});
	}
	// 글 삭제
	public int delete(int bId) {
		String sql = "DELETE FROM MVC_BOARD WHERE BID="+bId;
		return template.update(sql);
	}
	// 답변글 쓰기 전 작업 : stepA
	private void preReplyStepA(final int bgroup, final int bstep) {
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		template.update(sql,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, bgroup);
						pstmt.setInt(2, bstep);
					}
				});
	}
	// 답변글 쓰기
	public int reply(final BoardDto bDto) { // bname, btitle, bcontent, bip : 답변글에 대한 정보
		                             // bgroup, bstep, bindent : 원글에 대한 정보
		preReplyStepA(bDto.getbGroup(), bDto.getbStep());
		String sql = "INSERT INTO MVC_BOARD" + 
				" (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, ?, ?, ?, ?)";
		return template.update(sql,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setString(1, bDto.getbName());
						pstmt.setString(2, bDto.getbTitle());
						pstmt.setString(3, bDto.getbContent());
						pstmt.setInt(4, bDto.getbGroup());
						pstmt.setInt(5, bDto.getbStep()+1);
						pstmt.setInt(6, bDto.getbIndent()+1);
						pstmt.setString(7, bDto.getbIp());
					}
				});
	}
}