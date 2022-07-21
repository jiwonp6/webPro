package com.lec.ch14_practice.service;

import java.util.List;

import com.lec.ch14_practice.model.Dept;
import com.lec.ch14_practice.model.Emp;

public interface EmpService {
	public List<Emp> empList(Emp search);
	public List<Dept> deptList();
}
