package com.lec.ch14_practice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14_practice.model.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSession sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}
