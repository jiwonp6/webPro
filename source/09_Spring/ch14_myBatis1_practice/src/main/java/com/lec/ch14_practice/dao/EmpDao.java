package com.lec.ch14_practice.dao;

import java.util.List;

import com.lec.ch14_practice.model.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp search); 
	
}
