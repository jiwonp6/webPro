package com.lec.ch16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch16.dao.DeptDao;
import com.lec.ch16.dao.EmpDao;
import com.lec.ch16.model.Dept;
import com.lec.ch16.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao eDao;
	
	@Autowired
	private DeptDao dDao;
	
	@Override
	public List<Dept> deptList() {
		return dDao.deptList();
	}
	
	@Override
	public List<Emp> empList(Emp search) {
		if(search.getEname()!=null) {
			search.setEname(search.getEname().toUpperCase());	//대문자로 변환
		}
		if(search.getJob()!=null) {
			search.setJob(search.getJob().toUpperCase());
		}
		return eDao.empList(search);
	}

}
