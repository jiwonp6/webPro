package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.model.Board;
import com.lec.ch17.service.BoardService;
import com.lec.ch17.util.Paging;

@Controller
@RequestMapping("mvcboard/")
public class BoardController {

	@Autowired
	private BoardService bService;

	// boardList
	@RequestMapping(value = "/boardList", method = { RequestMethod.GET, RequestMethod.POST })
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList", bService.boardList(pageNum));
		int totCnt = bService.totCnt();
		model.addAttribute("paging", new Paging(totCnt, pageNum));
		return "mvcboard/boardList";
	}

	// 글쓰기View단
	@RequestMapping(value = "writeView", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView() {
		return "mvcboard/writeView";
	}

	// 글쓰기
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(@ModelAttribute("board") Board board, HttpServletRequest request, Model model) { // ip저장위해
		model.addAttribute("writeResult", bService.write(board, request)); 
		return "forward:boardList.do";
	}
	
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int bid, Model model) {
		model.addAttribute("hitUp",bService.hitUp(bid));
		model.addAttribute("board", bService.detail(bid));
		return "mvcboard/detail";
	}
	// detail_post
	@RequestMapping(value = "detail", method = RequestMethod.POST)
	public String detail_post(int bid, Model model) {
		model.addAttribute("board", bService.detail(bid));
		return "mvcboard/detail";
	}

	//update_get
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateView(int bid, Model model) {
		model.addAttribute("board", bService.detail(bid));
		return "mvcboard/update";
	}

	//update_post
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String modify(Board board, HttpServletRequest request, Model model) { // ip저장위해 request필요
		model.addAttribute("updateResult", bService.update(board, request));
		return "forward:detail.do";
	}

	// 글삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", bService.delete(bid));		
		return "forward:boardList.do";
	}

	// 답변글 View단
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("board", bService.detail(bid));
		return "mvcboard/replyView";
	}

	// 답변글
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(Board board, HttpServletRequest request, Model model) { // ip저장위해 request필요
		model.addAttribute("replyResult", bService.reply(board, request)); 
		return "forward:boardList.do";
	}
}
