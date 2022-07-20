package com.lec.ch14.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.model.Dept;

@Repository	//빈이 생성되어 수행하도록해줌
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSession sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}


}
