package com.lec.ex05_lib;

import java.util.Date;

public class BookTestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("89a-01", "java", "홍길동");
		BookLib book2 = new BookLib("89a-02", "DBMS", "이디비");
		System.out.println(book1);
		try {
			book1.checkOut("김빌림");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//대출일 조작
		book1.setCheckoutDate(new Date(122, 2, 11));	//3월 11일에 대출함으로 수정
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println("예외메세지:"+e.getMessage());
		}
		System.out.println(book1);
	
	}
	
}
