package com.lec.ch14_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch14_practice.model.Emp;
import com.lec.ch14_practice.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String emp(@ModelAttribute("search") Emp search, Model model) {
		model.addAttribute("emp", empService.empList(search));
		model.addAttribute("deptList", empService.deptList());
		return "emp";
	}
}
