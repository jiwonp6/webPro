package com.lec.ex05_lib;

import java.util.Date;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("89a-01","java","ȫ�浿");
		BookLib book2 = new BookLib("89a-02","DBMS","�ű浿");
		BookLib book3 = new BookLib("89a-03","jsp","���浿");
		System.out.println(book1);
		try {
			book1.checkOut("�����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// ������ ����
		book1.setCheckOutDate(new Date(122,2,11));
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println("���� �޼��� : "+e.getMessage());
		}
		System.out.println(book1);
		
				
	}
}
