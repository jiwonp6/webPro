package com.lec.ch17.util;

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
	private int startRow;
	private int endRow;
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int endPage;
	
	private int orderNum;
	private int inverseNum;

	//Paging paging = new Paging(14, pageNum, 10, 5)
	public Paging(int totCnt, String pageNum, int pageSize, int blockSize) {
		if(pageNum!=null) {
			currentPage=Integer.parseInt(pageNum);
		}
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		startRow = (currentPage-1) * pageSize+1;
		endRow = startRow + pageSize -1;
		orderNum = startRow;
		this.totCnt= totCnt;
		inverseNum = totCnt - startRow + 1;
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
		startRow = (currentPage-1) * pageSize+1;
		endRow = startRow + pageSize -1;
		orderNum = startRow;
		this.totCnt= totCnt;
		inverseNum = totCnt - startRow + 1;
		pageCnt = (int)Math.ceil((double)totCnt/pageSize);
		startPage = currentPage - (currentPage-1)%blockSize;
		endPage = startPage + blockSize - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
	}
	
	
	
}
