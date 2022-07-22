package com.lec.ch16.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging {
	private int currentPage = 1;
	private int pageSize;
	private int blockSize;
	private int startrow;
	private int endrow;
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int endPage;

	//Paging paging = new Paging(14, pageNum, 10, 5)
	public Paging(int totCnt, String pageNum, int pageSize, int blockSize) {
		if(pageNum!=null) {
			currentPage=Integer.parseInt(pageNum);
		}
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		startrow = (currentPage-1) * pageSize+1;
		endrow = startrow + pageSize -1;
		this.totCnt= totCnt;
		pageCnt = (int)Math.ceil((double)totCnt/pageSize);
		startPage = currentPage - (currentPage-1)%blockSize;
		endPage = startPage + blockSize - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
	}
	//Paging paging = new Paging(14, pageNum)
	public Paging(int totCnt, String pageNum) {
		if(pageNum!=null) {
			currentPage=Integer.parseInt(pageNum);
		}
		this.pageSize = 10;
		this.blockSize = 10;
		startrow = (currentPage-1) * pageSize+1;
		endrow = startrow + pageSize -1;
		this.totCnt= totCnt;
		pageCnt = (int)Math.ceil((double)totCnt/pageSize);
		startPage = currentPage - (currentPage-1)%blockSize;
		endPage = startPage + blockSize - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
	}
	
	
	
}
