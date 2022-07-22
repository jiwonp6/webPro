package com.lec.ch16.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;   // 상사 사번
	private Timestamp hiredate;
	private int sal;   // 봉급
	private int comm;  // 상여
	private int deptno; // 부서번호
}
