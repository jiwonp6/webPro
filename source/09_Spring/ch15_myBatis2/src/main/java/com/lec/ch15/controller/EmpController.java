package com.lec.ch15.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.model.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	//empList
	@RequestMapping(value="empList", method=RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		//eg) empList.do?pageNum=2 / empList.do(pageNum==null)
		model.addAttribute("empList", empService.empList(pageNum));
		int totCnt = empService.totCnt();
		model.addAttribute("paging", new Paging(totCnt, pageNum, 10, 5));
		return "empList";
	}
	//dummyDataInsert
	@RequestMapping(value="dummyDataInsert", method=RequestMethod.GET)
	public String dummyDataInsert() {
		empService.dummyDataInsert50();
		return "redirect:empList.do";
	}
	//empDeptList
	@RequestMapping(value="empDeptList", method= {RequestMethod.GET, RequestMethod.POST})
	public String empDeptList(String pageNum, Model model) {
		//empDeptList.do, empDeptList.do?pageNum=2
		model.addAttribute("empDeptList", empService.empDeptList(pageNum));
		int totCnt = empService.totCnt();
		model.addAttribute("paging", new Paging(totCnt, pageNum, 10, 5));
		return "empDeptList";
	}
	//detail
	@RequestMapping(value="detail", method= RequestMethod.GET)
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "detail";
	}
	//insertView
	@RequestMapping(value="insertView", method= {RequestMethod.GET, RequestMethod.POST})
	public String insertView(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return  "insert";
	}
	//insert
	@RequestMapping(value="insert", method= RequestMethod.POST)
	public String insert(Emp emp, String tempHiredate, Model model) {
		emp.setHiredate(Timestamp.valueOf(tempHiredate + " 00:00:00"));
		try {
			model.addAttribute("insertResult", empService.insert(emp));
		} catch (Exception e) {
			model.addAttribute("insertResult", "필드 값이 너무 깁니다. 회원등록 실패");
			System.out.println(e.getMessage());
			return "forward:insertForm.do";
		}
		return  "forward:empDeptList.do";
	}
	//insert시 confirmNo
	@RequestMapping(value="confirmNo", method= RequestMethod.GET)
	public String confrimNo(int empno, Model model) {
		if(empService.detail(empno) == null) {
			model.addAttribute("msg", "사용가능 사번");
		}else {
			model.addAttribute("msg", "중복된 사번은 사용 불가능");
		}
		return  "forward:insertView.do";
	}
	//update_get
	@RequestMapping(value="updateView", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateView(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "update";
	}
	//update_post
	@RequestMapping(value="update", method= RequestMethod.POST)
	public String update(Emp emp, String tempHiredate, Model model) {
		emp.setHiredate(Timestamp.valueOf(tempHiredate + " 00:00:00"));
		try {
			model.addAttribute("updateResult", empService.update(emp));
		} catch (Exception e) {
			model.addAttribute("updateResult", "필드 값이 너무 깁니다. 수정 실패");
			System.out.println(e.getMessage());
			return "forward:updateView.do";
		}
		return "forward:empDeptList.do";
	}
	//delete
	@RequestMapping(value="delete", method= RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";
	}
	
}
