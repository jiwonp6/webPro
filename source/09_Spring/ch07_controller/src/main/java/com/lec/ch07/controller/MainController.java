package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	//http://llocalhost:8090/ch07/	요청처리
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("greeting", "안녕하세요");
		return "main";	//view단의 jsp : /WEB-INF/views/main.jsp
	}
}
