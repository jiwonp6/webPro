package com.lec.ex08_book2;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890ㅁ-1010-1ㄱ", "java", "홍길동"), 
							new BookLib("110ㄱ-5268-2ㅂ", "oracle", "신길동"),
							new BookLib("120ㄷ-8695-3ㅈ", "mysql", "박길동")};
		CDLib[] cds = { new CDLib("c01", "java_cd", "a01"), 
						new CDLib("c02", "ITtrend", null),
						new CDLib("c03", "jsp", "a02") 	};
		Scanner sc = new Scanner(System.in);
		int fn;		//기능번호(1:대출, 2:반납, 3:책list, 0:종료)
		int idx;	//대출하거나 반납하려고 할 때 조회된 책의 index
		String bTitle, cTitle, borrower, checkOutDate;
	//do~while문
		do {
			System.out.println("1:대출, 2:CD대출, 3:책반납, 4:CD반납, 5:list, 0:종료");
			fn = sc.nextInt();	
	//switch문
			switch (fn) {
			case 1:
				System.out.println("대출하고자 하는 책이름 : ");
				bTitle = sc.next();
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");
				}else {	
					if(books[idx].getState()==BookLib.STATE_BORROWED) {	//대출불가능 상태
						System.out.println("현재 대출중인 도서입니다.");
					}else {
						System.out.println("대출 가능합니다.");
						System.out.println("대출자는 : ");
						borrower = sc.next();
						System.out.println("대출일은 : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2:
				System.out.println("대출하고자 하는 CD이름 : ");
				cTitle = sc.next();
				for(idx=0; idx<cds.length; idx++) {
					if(cTitle.equals(cds[idx].getCdTitle())) {
						break;
					}
				}
				if(idx==cds.length) {
					System.out.println("현재 보유하지 않은 CD입니다.");
				}else {	
					if(cds[idx].getState()==CDLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 CD입니다.");
					}else {	
						System.out.println("대출 가능합니다.");
						System.out.println("대출자는 : ");
						borrower = sc.next();
						System.out.println("대출일은 : ");
						checkOutDate = sc.next();
						cds[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 3:
					System.out.println("반납할 책이름은? ");
					bTitle = sc.next();
					for(idx=0; idx<books.length; idx++) {
						if(bTitle.equals(books[idx].getBookTitle())){
							break;
						}
					}
					if(idx == books.length) {
						System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
					}else {	
						books[idx].checkIn();
					}
				break;
			case 4:
				System.out.println("반납할 CD이름은? ");
				cTitle = sc.next();
				for(idx=0; idx<cds.length; idx++) {	//확장for문 쓰면 인덱스를 가져올 수 없음
					if(cTitle.equals(cds[idx].getCdTitle())){
						break;
					}
				}
				if(idx == cds.length) {
					System.out.println("해당 CD는 본 도서관의 CD가 아닙니다.");
				}else {	
					cds[idx].checkIn();
				}
				break;
			case 5:
				System.out.println("\t===책 list===");
				for(BookLib book : books) {
					book.printState();				
				}
				System.out.println("\t===Cd list===");
				for(CDLib cd : cds) {
					cd.printState();
				}
				break;
			}
		}while(fn!=0);
			System.out.println("bye");	
		}
	
	}

