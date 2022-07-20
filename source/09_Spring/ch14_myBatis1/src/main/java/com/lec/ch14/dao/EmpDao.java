package com.lec.ch14.dao;

import java.util.List;

import com.lec.ch14.model.Emp;


public interface EmpDao {
	public List<Emp> empList(Emp search);
}
