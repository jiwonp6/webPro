package com.lec.ch10.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;
@Controller
public class MyController {
	@RequestMapping(value="inputForm.do", method=RequestMethod.GET )
	public String inputForm() {
		return "ex/inputForm";
	}
	@RequestMapping(value = "input.do", method = RequestMethod.GET)
	public String input(Student student, Errors errors, Model model) {
		String viewPage = "ex/inputResult";
		StudentValidator validator = new StudentValidator();
		validator.validate(student, errors);
		if (errors.hasErrors()) {
			viewPage = "ex/inputForm";
			if(errors.getFieldError("name")!=null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			if(errors.getFieldError("id")!=null) {
				model.addAttribute("idError", "id는 자연수만 입력가능");
			}
			return "ex/inputForm";
		}
		return viewPage;
	}
	@InitBinder
	protected void initBnder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}

}
