package com.lec.ch14.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.model.Emp;

@Repository	//빈이 생성되어 수행하도록해줌
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Emp> empList(Emp search) {
		//search.getEname() -> "A" and search.getJob()-> "E" and search.getDeptno() -> 20
		return sessionTemplate.selectList("empList", search);
	}

}
