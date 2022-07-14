package com.lec.ch07.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;

// board/write, board/content, board/list, board/reply
@Controller
@RequestMapping("board/")	//공통요청경로
public class BoardController {
	@RequestMapping("write")	//조합된 요청경로 : board/writer
	public String write() {
		return "board/write";	//view : /WEB-INF/views/board/write.jsp
	}
	@RequestMapping(value="content", method=RequestMethod.GET)
	public String content(Model model) {	//String의 Model : model.addAttribute를 사용하여 데이터만 저장
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		return "board/content";
	}
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		Member member = new Member("ccc","333");
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member);
		mav.addObject("list", list);	//데이터
		mav.setViewName("board/list");	//view단(이름으로 세팅)
		return mav;
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {	//ModelAndView : 데이터와 이동하고자 하는 View Page를 같이 저장
		Member member = new Member("ddd","444");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
}
