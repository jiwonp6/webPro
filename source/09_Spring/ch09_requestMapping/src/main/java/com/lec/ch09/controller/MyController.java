package com.lec.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main.do", method=RequestMethod.GET )	//value="main"도 가능
	public String main() {
		return "main";
	}
	/*
	@RequestMapping(value="student.do")
	public String student(String id, Model model, HttpServletRequest request) {
		String method = request.getMethod();
		model.addAttribute("method", method);
		model.addAttribute("id", id);
		return "studentId";
	}
	*/
	@RequestMapping(value="student.do", method=RequestMethod.GET)
	public String student(String id, Model model) {
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value="student.do", method=RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav) {
		mav.addObject("method", "POST");
		mav.addObject("id", id);
		mav.setViewName("studentId");
		return mav;
	}
	@RequestMapping(value="idConfirm.do", method=RequestMethod.GET)
	public String idConfirm(String id, Model model ) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			return "forward:studentOK.do";	//forward=redirect
			//return "forward:studentOk.do";
		}
		return "redirect:studentNg.do?id="+id;
	}
	@RequestMapping(value="studentOK.do", method=RequestMethod.GET)
	public String studentOK(String id, Model model ) {
		return "studentOK";
	}
	@RequestMapping(value="studentNg.do", method=RequestMethod.GET)
	public String studentNg(String id) {
		return "studentNg";
	}
	@RequestMapping(value="fullpath.do", method=RequestMethod.GET)
	public String fullpath() {
		return "redirect:http://www.naver.com";
	}
}
