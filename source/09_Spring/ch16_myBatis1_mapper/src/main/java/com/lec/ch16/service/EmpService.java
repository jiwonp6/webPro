package com.lec.ch16.service;

import java.util.List;

import com.lec.ch16.model.Dept;
import com.lec.ch16.model.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp search);
}
