package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//list.do 또는 list.do?pageNum=2 또는 list.do?pageNum=10
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum="1";
		}
			int currentPage = Integer.parseInt(pageNum);
			final int PAGESIZE=10, BLOCKSIZE = 10;
			int startRow = (currentPage-1)*PAGESIZE + 1;
			int endRow = startRow + PAGESIZE - 1;
			BoardDao bDao = BoardDao.getInstance();
			request.setAttribute("list", bDao.listBoard(startRow, endRow));	//★글목록
			int totalCnt = bDao.getBoardTotalCnt();	//등록된 글 개수
			int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE);	//페이지 수
			int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE +1;
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage>pageCnt) {
				endPage = pageCnt;
			}
			//★ 이하 페이지 관련 항목들
			request.setAttribute("BLOCKSIZE", BLOCKSIZE);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageNum", currentPage);	//현재페이지를 pageNum으로 (인티저 객체로 넘어감) 
			request.setAttribute("pageCnt", pageCnt);
	}

}
