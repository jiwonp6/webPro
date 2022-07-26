package com.lec.ch19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String mid;
	private String mpw;
	private String mname;
	private String mmail;
	private String mpost;
	private String maddr;
}
