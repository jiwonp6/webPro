package com.lec.ch19.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch19.dto.Book;

public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(String pageNum, Book book);
	//public int totCntBook();
	public Book getDetailBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	// public int registerBook(MultipartHttpServletRequest mRequest) <- 이렇게 사용하기도 하지만 비추
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
	public int deleteBook(int bnum);
	public int cntBook(Book book);
}
