package com.lec.ch17.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.model.Board;
import com.lec.ch17.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao bDao;
	
	@Override
	public List<Board> boardList(String pageNum) {
		int totCnt = bDao.totCnt();
		Paging paging = new Paging(totCnt, pageNum);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return bDao.boardList(board);
	}

	@Override
	public int totCnt() {
		return bDao.totCnt();
	}

	@Override
	public int write(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return bDao.write(board);
	}

	@Override
	public int hitUp(int bid) {
		return bDao.hitUp(bid);
	}

	@Override
	public Board detail(int bid) {
		return bDao.detail(bid);
	}

	@Override
	public int update(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return bDao.update(board);
	}

	@Override
	public int delete(int bid) {
		return bDao.delete(bid);
	}
	
	@Override
	public int preReply(Board board) {
		return bDao.preReply(board);
	}
	
	@Override
	public int reply(Board board, HttpServletRequest request) {
		preReply(board);
		board.setBip(request.getRemoteAddr());
		board.setBstep(board.getBstep()+1);
		board.setBindent(board.getBindent()+1);
		return bDao.reply(board);
	}
	

}
