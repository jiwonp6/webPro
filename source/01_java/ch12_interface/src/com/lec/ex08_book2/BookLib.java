package com.lec.ex08_book2;
//boolean넣어서 cd딸린 책인지 미리 true false로 받을 수 있음.
public class BookLib extends BookInfo implements Ilendable {
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public BookLib(String requestNo, String bookTitle, String writer) {
		super(requestNo, bookTitle, writer);
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
		System.out.println("\""+getBookTitle()+"\"이(가) 대출되었습니다.");
		System.out.println("[대출인]"+borrower);
		System.out.println("[대출일]"+checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state != STATE_NORMAL) {	//대출 중이었음
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("\""+getBookTitle()+"\""+"이(가) 반납되었습니다.");
			return;
		}
		//대출기록이 없음 -> 반납불가
		System.out.println("시스템오류");
	}

	@Override
	public void printState() {
		String msg = getRequestNo() + "\t\""+getBookTitle()+"\""+"("+getWriter()+"著)\t";
		msg = msg + ((state==STATE_NORMAL) ? "대출가능" : (state==STATE_BORROWED)? "대출중" : "시스템오류");
		System.out.println(msg);
	}
	//getter&setter
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
}
