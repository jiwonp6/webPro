package com.lec.ex07_book1;
//Book b = new Book("890ㅁ-1010-1ㄱ", "java", "홍길동")
public class Book implements Ilendable {
	private String requestNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte state;	//대출불가(1), 대출가능(0)
	
	public Book(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state != STATE_NORMAL) {
			System.out.println("대출불가");
			return;	// 대출불가이면 바로 시스템 중단하고 메인으로(else안써도 됨, void라서 리턴 값은 안되고 리턴만 쓰면 가능)
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println("\""+bookTitle+"\"이(가) 대출되었습니다.");
		System.out.println("[대출인]"+borrower);
		System.out.println("[대출일]"+checkOutDate);
	}
	@Override
	public void checkIn() {	//반납처리 후 다시 null값으로 
		if(state != STATE_NORMAL) {	//대출 중이었음
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("\""+bookTitle+"\""+"이(가) 반납되었습니다.");
			return;
		}
		//대출기록이 없음 -> 반납불가
		System.out.println("시스템오류");
	}
	@Override
	public void printState() {
		//삼항연산자
		String msg = requestNo + "\t\""+bookTitle+"\""+"("+writer+"著)\"t";
		msg = msg + ((state==STATE_NORMAL) ? "대출가능" : (state==STATE_BORROWED)? "대출중" : "시스템오류");
		System.out.println(msg);
		//if문
//		if(state==STATE_NORMAL) {
//			System.out.println("대출가능");
//		}else if(state==STATE_BORROWED) {
//			System.out.println("대출중");
//		}else {
//			System.out.println("시스템오류");
//		}
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public String getWriter() {
		return writer;
	}
	public String getBorrower() {
		return borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public byte getState() {
		return state;
	}
}
