package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Book[] books = {new Book("890ㅁ-1010-1ㄱ", "java", "홍길동"), 
				new Book("110ㄱ-5268-2ㅂ", "oracle", "신길동"),
				new Book("120ㄷ-8695-3ㅈ", "mysql", "박길동")};
		Scanner sc = new Scanner(System.in);
		int fn;		//기능번호(1:대출, 2:반납, 3:책list, 0:종료)
		int idx;	//대출하거나 반납하려고 할 때 조회된 책의 index
		String bTitle, borrower, checkOutDate;	//사용자에게 받을 책이름, 대출인, 대출일
	//do~while문
		do {
			System.out.println("1:대출, 2:반납, 3:책list, 0:종료");
			fn = sc.nextInt();	
	//switch문
			switch (fn) {
			case 1:	//대출 : 1.책이름입력 2.책조회 3.대출가능여부확인 
								//4.대출인입력 5.대출일입력 6.대출메소드 호출
				//1.책이름입력
				System.out.println("대출하고자 하는 책이름 : ");
				bTitle = sc.next();	//스페이스포함X
				//2.책조회
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}//책조회for
				if(idx==books.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");
				}else {	//books[idx] 도서를 대출 처리
				//3.대출가능여부확인
					if(books[idx].getState()==Book.STATE_BORROWED) {	//대출불가능 상태
						System.out.println("현재 대출중인 도서입니다.");
					}else {	//대출가능상태
						System.out.println("대출 가능합니다.");
				//4.대출인입력
						System.out.println("대출자는 : ");
						borrower = sc.next();
				//5.대출일입력
						System.out.println("대출일은 : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2://반납 : 1.책이름 2.책조회 3.반납처리
					//1.책이름
					System.out.println("반납할 책이름은? ");
					bTitle = sc.next();
					for(idx=0; idx<books.length; idx++) {	//확장for문 쓰면 인덱스를 가져올 수 없음
						if(bTitle.equals(books[idx].getBookTitle())){
							break;
						}
					}//2.책조회
					if(idx == books.length) {
						System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
					}else {	//idx가 찾은 그 위치
					//3.반납처리
						books[idx].checkIn();
					}
				
				break;
			case 3:
				System.out.println("\t===책 list===");
				for(Book book : books) {
					book.printState();				
				}
				break;
		}
		}while(fn!=0);
			System.out.println("bye");
		
	//while문
//		while(true) {
//			System.out.println("1:대출, 2:반납, 3:책list, 0:종료");
//			fn = sc.nextInt();
//			if(fn==0) {
//				break;
//			}
			
		}
	
	}

