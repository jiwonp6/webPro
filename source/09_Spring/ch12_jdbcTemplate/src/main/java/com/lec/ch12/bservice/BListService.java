package com.lec.ch12.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;

public class BListService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//as.Map() : model을 Map화
		String pageNum = (String)map.get("pageNum");
		if(pageNum == null) {
			pageNum="1";
		}
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("boardList", boardDao.boardList(startRow, endRow));
		int orderNum = startRow; 					// 출력될 순번호(1,2,3 순)
		int totCnt = boardDao.getBoardTotCnt(); 	// 전체 글 갯수
		int inverseNum = totCnt - startRow + 1; 	// 출력될 역순번호
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage  = currentPage - (currentPage-1)%BLOCKSIZE;
		// = startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("pageNum", currentPage);

	}

}
