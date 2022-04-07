package com.lec.ex05_lib;

import java.util.Date;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("89a-01","java","홍길동");
		BookLib book2 = new BookLib("89a-02","DBMS","신길동");
		BookLib book3 = new BookLib("89a-03","jsp","유길동");
		System.out.println(book1);
		try {
			book1.checkOut("김빌림");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 대출일 조작
		book1.setCheckOutDate(new Date(122,2,11));
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println("예외 메세지 : "+e.getMessage());
		}
		System.out.println(book1);
		
				
	}
}
