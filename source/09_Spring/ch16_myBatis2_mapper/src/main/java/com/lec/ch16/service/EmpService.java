package com.lec.ch16.service;

import java.util.List;

import com.lec.ch16.model.Dept;
import com.lec.ch16.model.Emp;

public interface EmpService {	//service 인터페이스에 dao의 함수들 넣음
	public List<Dept> deptList();
	public List<Emp> empList(String pageNum);	//paging처리가 필요한 함수들만 매개변수로 pageNum을 받는다
	public List<Emp> empDeptList(String pageNum); 
	public int totCnt();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public void dummyDataInsert50();
}
