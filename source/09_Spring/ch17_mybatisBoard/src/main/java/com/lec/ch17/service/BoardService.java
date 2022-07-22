package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.ch17.model.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int totCnt();
	public int write(Board board, HttpServletRequest request);
	public int hitUp(int bid);
	public Board detail(int bid);
	public int update(Board board, HttpServletRequest request);
	public int delete(int bid);
	public int reply(Board board, HttpServletRequest request);
}
