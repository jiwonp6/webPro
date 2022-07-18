package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.bservice.BContentService;
import com.lec.ch11.bservice.BDeleteService;
import com.lec.ch11.bservice.BWriteService;
import com.lec.ch11.bservice.BListService;
import com.lec.ch11.bservice.BModifyReplyViewService;
import com.lec.ch11.bservice.BModifyService;
import com.lec.ch11.bservice.BReplyService;
import com.lec.ch11.bservice.Service;
import com.lec.ch11.dto.BoardDto;

//list.do, writeView.do, write.do, content.do, modify.do, reply.do
@Controller
@RequestMapping("mvcboard")
public class BoardController {
	private Service bservice;
	//글 리스트
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(String pageNum, Model model) {	//mvcboard/list.do?pageNum=2
		model.addAttribute("pageNum", pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	//글 리스트	post방식
	@RequestMapping(value="list", method=RequestMethod.POST)
	public String list_post(String pageNum, Model model) {	//mvcboard/list.do?pageNum=2
		model.addAttribute("pageNum", pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	//글쓰기View단
	@RequestMapping(value="writeView", method=RequestMethod.GET)
	public String writeView() {
		return "mvcboard/writeView";
	}
	//글쓰기
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute("bDto") BoardDto boardDto, HttpServletRequest request, Model model) {		//ip저장위해 request필요
		model.addAttribute("request", request);		//service 단에서 ip 추출을 위함(request.getRemoteAddr())
		bservice = new BWriteService();
		bservice.execute(model);
		return "forward:list.do";	//jsp단으로 가면 안됨, 정보를 그대로 가지고 가야하므로 forward로 보내줌(공통요청경로 빼서)
	}
	//글내용
	@RequestMapping(value="content", method= RequestMethod.GET)
	public String content(int bId, Model model) {	
		model.addAttribute("bId", bId);
		bservice = new BContentService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	//글내용_post
	@RequestMapping(value="content", method= RequestMethod.POST)
	public String content_post(int bId, Model model) {	
		model.addAttribute("bId", bId);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	//글수정View단
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyView(int bId, Model model) {
		model.addAttribute("bId", bId);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/modify";
	}
	//글수정
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(BoardDto boardDto, HttpServletRequest request, Model model) {		//ip저장위해 request필요
		model.addAttribute("request", request);
		bservice = new BModifyService();
		bservice.execute(model);
		return "forward:content.do";
	}
	//글삭제
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bId, Model model) {	
		model.addAttribute("bId", bId);
		bservice = new BDeleteService();
		bservice.execute(model);
		return "forward:list.do";
	}
	//답변글 View단
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String replyView(int bId, Model model) {
		model.addAttribute("bId", bId);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/replyView";
	}
	//답변글
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(BoardDto boardDto, HttpServletRequest request, Model model) {	//ip저장위해 request필요
		model.addAttribute("request", request);
		bservice = new BReplyService();
		bservice.execute(model);
		return "forward:list.do";
	}
	
	
}
