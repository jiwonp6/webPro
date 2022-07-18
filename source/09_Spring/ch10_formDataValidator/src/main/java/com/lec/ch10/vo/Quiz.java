package com.lec.ch10.vo;

import lombok.Data;

@Data
public class Quiz {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public int tot() {
		return kor+eng+mat;
	}
	public double avg() {
		return ((kor+eng+mat)/3.0);
	}
}
