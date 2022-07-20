package com.lec.ch14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch14.model.Dept;
import com.lec.ch14.model.Emp;
import com.lec.ch14.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
	@ModelAttribute("deptList")
	public List<Dept> deptList(){
		return service.deptList();
	}
	
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String emp(@ModelAttribute("search") Emp search, Model model) {
		model.addAttribute("emp", service.empList(search));
		//model.addAttribute("deptList", service.deptList());
		return "emp";
	}

}
