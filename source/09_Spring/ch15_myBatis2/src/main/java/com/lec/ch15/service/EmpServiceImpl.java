package com.lec.ch15.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch15.dao.DeptDao;
import com.lec.ch15.dao.EmpDao;
import com.lec.ch15.model.Dept;
import com.lec.ch15.model.Emp;
import com.lec.ch15.util.Paging;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}

	@Override
	public List<Emp> empList(String pageNum) {
		int totCnt = empDao.totCnt();
		Paging paging = new Paging(totCnt, pageNum, 10, 5);
		Emp emp = new Emp();
		emp.setStartrow(paging.getStartrow());
		emp.setEndrow(paging.getEndrow());
		return empDao.empList(emp);
	}

	@Override
	public List<Emp> empDeptList(String pageNum) {
		int totCnt = empDao.totCnt();
		Paging paging = new Paging(totCnt, pageNum, 10, 5);
		Emp emp = new Emp();
		emp.setStartrow(paging.getStartrow());
		emp.setEndrow(paging.getEndrow());
		return empDao.empDeptList(emp);
	}

	@Override
	public int totCnt() {
		return empDao.totCnt();
	}

	@Override
	public Emp detail(int empno) {
		return empDao.detail(empno);
	}

	@Override
	public List<Emp> managerList() {
		return empDao.managerList();
	}

	@Override
	public int insert(Emp emp) {
		return empDao.insert(emp);
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}

	@Override
	public void dummyDataInsert50() {
		Emp emp = new Emp();
		for(int i=5000; i<5050; i++) {
			emp.setEmpno(i);
			emp.setEname("박박"+i);
			emp.setJob("IT");
			emp.setMgr(7566);
			emp.setHiredate(Timestamp.valueOf("2022-07-21 14:00:00"));
			//Date형 일 경우 : emp.setHiredate(Date.valueOf("2022-07-21"));
			emp.setSal(i);
			emp.setComm(i/10);
			emp.setDeptno(40);
			int result = empDao.insert(emp);
			System.out.println(result==1?i+"번째 성공":i+"번째 실패");
		}
	}

}
