package com.lec.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String id;
	private String pw;
	@Override
	public String toString() {
		return "Member [아이디=" + id + ", 비번=" + pw + "]";
	}
	
}
