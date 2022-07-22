package com.lec.ch16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
}
