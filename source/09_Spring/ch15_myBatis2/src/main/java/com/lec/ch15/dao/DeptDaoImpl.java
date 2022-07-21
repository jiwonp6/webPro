package com.lec.ch15.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch15.model.Dept;

@Repository	//스프링에게 DAO임을 알려주는 어노테이션(빈생성)
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSession sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}
