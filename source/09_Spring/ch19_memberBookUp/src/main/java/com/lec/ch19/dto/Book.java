package com.lec.ch19.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private int bnum;
	private String btitle;
	private String bwriter;
	private Date brdate;
	private String bimg1;
	private String bimg2;
	private String binfo;
	private int startRow;
	private int endRow;
	private String schItem; // 검색하려고 선택된 항목 (책이름=btitle or 저자=bwriter)
	private String schWord; // 검색할 단어
}
