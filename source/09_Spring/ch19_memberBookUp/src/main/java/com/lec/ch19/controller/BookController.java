package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.util.Paging;
import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bService;
	
	//bookList
	@RequestMapping(params="method=list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Book book, Model model) {
		model.addAttribute("bookList", bService.bookList(pageNum, book));
		int totCntBook = bService.cntBook(book);
		model.addAttribute("paging", new Paging(totCntBook, pageNum, 3, 3));
		return "book/list";
	}
	//register
	@RequestMapping(params="method=registerForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String registerForm(Model model) {
		return "book/registerForm";
	}
	@RequestMapping(params="method=register", method= RequestMethod.POST)
	public String register(Book book, MultipartHttpServletRequest mRequest, Model model) {
		model.addAttribute("registerResult", bService.registerBook(mRequest, book));
		return "forward:book.do?method=list";
	}
	//detail
	@RequestMapping(params="method=detail", method= {RequestMethod.GET, RequestMethod.POST})
	public String detail(int bnum, String pageNum, Model model) {
		model.addAttribute("detail", bService.getDetailBook(bnum));
		model.addAttribute("pageNum", pageNum);
		return "book/detail";
	}
	//modify
	@RequestMapping(params="method=modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(int bnum, String pageNum, Model model) {
		model.addAttribute("bookDetail", bService.getDetailBook(bnum));
		model.addAttribute("pageNum", pageNum);
		return "book/modifyForm";
	}
	@RequestMapping(params="method=modify", method= RequestMethod.POST)	
	public String modify(Book book, String pageNum, MultipartHttpServletRequest mRequest,  HttpSession httpSession, Model model) {
		model.addAttribute("modifyResult", bService.modifyBook(mRequest, book));
		httpSession.setAttribute("book", book);
		System.out.println("수정완료");
		return "redirect:book.do?method=list&pageNum="+pageNum;
	}
	//delete
	@RequestMapping(params="method=delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(int bnum, String pageNum, Model model) {
		model.addAttribute("deleteResult", bService.deleteBook(bnum));
		/* return "redirect:book.do?method=list&pageNum="+pageNum; */
		return "forward:book.do?method=list";
	}
	
}
