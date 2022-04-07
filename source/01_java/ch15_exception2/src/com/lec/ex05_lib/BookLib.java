package com.lec.ex05_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo; // 책 번호
	private String bookTitle; // 책 이름
	private String writer; // 저자
	private String borrower; // 대출인
	private Date checkOutDate; // 대출일
	private byte state; // 대출중 (1) or 대출가능(0)

	public BookLib() {
	}

	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	// 도서상태확인 -> 대출로직 -> 도서상태출력
	@Override
	public void checkOut(String borrower) throws Exception {
		if (state == STATE_BORROWED) {
			throw new Exception(bookTitle + " 도서는 ★대출중★ 입니다."); // 강제로 예외 발생
		}
		// 대출 로직
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		// java 도서가 대출되었습니다. 대출인 : 신길동 대출일: 2022-4-4 2주이내에 반납하세요
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		System.out.println("\"" + bookTitle + "\" 도서가 대출되었습니다.");
		System.out.println("대출인 : " + borrower + " / 대출일 : " + sdf.format(checkOutDate) + "2주내로 반납하세요.");
	}

	// book.checkIn() : 도서상태 확인 -> 연체여부 확인 -> (if. 연체되었을경우 연체료 납부 y/n) -> 반납로직 ->
	// 상태출력
	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception(bookTitle + " 도서는 대출중이 아니에요");
		}
		// 연체여부 확인 checkOutDate ~ 현재까지 14일 이내인지 여부
		Date now = new Date();
		long diff = (now.getTime()) - (checkOutDate.getTime());
		long day = diff / (1000 * 60 * 60 * 24);
		if (day > 14) { // 연체 여부 14보다 크면 연체
			System.out.println("연체료는 일일 100원 부가됩니다. 내셔야할 연체료는 : "+(day-14)*100 +" 원 입니다.");
			Scanner sc = new Scanner(System.in);
			System.out.print("연체료를 내셨나요? ( Y/N ) : ");
			if( ! sc.next().equalsIgnoreCase("y")) { // 연체료를 냈다고 y를 입력하지 않은경우 
				System.out.println("연체료를 내셔야 반납처리가 가능합니다. 연체료를 내세요.");
				return;
			}
		} // 연체 안된경우 반납로직 
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\"도서가 ★반납★ 되었습니다. ");

	}
	// sysout(book)  - > 책번호 , 책이름, 저자 , 대출가능 출력 
	//               - > 책번호, 책이름, 저자, 대출중( 대출일 ) 출력
	@Override
	public String toString() {
		String msg = "책 번호 : "+ bookNo + " 책 이름 : "+ bookTitle + " 저자 : "+ writer;		
		msg += (state == STATE_NORMAL) ? "\t대출가능" : "\t대출중";
		if(state == STATE_BORROWED) {
			// 빌린시점 + 14일을 한 날짜 즉 date = 반납예정일
//			Date date = new Date(checkOutDate.getTime() + (1000*60*60*24*14)); 
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
			SimpleDateFormat sdf = new SimpleDateFormat(" ( 대출일 : yyyy-MM-dd(E))");
//			msg += sdf.format(date);
			msg += sdf.format(checkOutDate);
		}
		return msg;
		
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	

}
