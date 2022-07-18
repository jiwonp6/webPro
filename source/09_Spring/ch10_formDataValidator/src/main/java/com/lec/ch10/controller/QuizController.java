package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Quiz;
import com.lec.ch10.vo.QuizValidator;

@Controller
public class QuizController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	@RequestMapping(value="quizInput", method=RequestMethod.GET)
	public String quizInput() {
		return "quiz/quizInput";
	}
	@RequestMapping(value="quizInput", method=RequestMethod.POST)
	public String quizInput(Quiz quiz, Errors errors, Model model) {
		String viewPage = "quiz/quizResult";
		QuizValidator validator = new QuizValidator();
		validator.validate(quiz, errors);
		if (errors.hasErrors()) {
			viewPage = "quiz/quizInput";
			if(errors.getFieldError("name")!=null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			if(errors.getFieldError("kor")!=null) {
				model.addAttribute("korError", "점수는 0~100점 사이");
			}
			if(errors.getFieldError("eng")!=null) {
				model.addAttribute("korError", "점수는 0~100점 사이");
			}
			if(errors.getFieldError("mat")!=null) {
				model.addAttribute("korError", "점수는 0~100점 사이");
			}
			return viewPage;
		}
		return viewPage;
	}
}
