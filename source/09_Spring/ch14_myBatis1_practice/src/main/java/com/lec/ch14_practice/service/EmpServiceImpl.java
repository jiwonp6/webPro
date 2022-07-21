package com.lec.ch14_practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch14_practice.dao.DeptDao;
import com.lec.ch14_practice.dao.EmpDao;
import com.lec.ch14_practice.model.Dept;
import com.lec.ch14_practice.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao eDao;
	
	@Autowired
	private DeptDao dDao;
	
	@Override
	public List<Emp> empList(Emp search) {
		if(search.getEname()!=null) {
			search.setEname(search.getEname().toUpperCase());
		}
		if(search.getJob()!=null) {
			search.setJob(search.getJob().toUpperCase());
		}
		return eDao.empList(search);
	}

	@Override
	public List<Dept> deptList() {
		return dDao.deptList();
	}

}
