package com.lec.ch14.service;

import java.util.List;

import com.lec.ch14.model.Dept;
import com.lec.ch14.model.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp search);
}
