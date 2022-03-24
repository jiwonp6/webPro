package com.lec.ex08_book2;

public class CDLib extends CDInfo implements Ilendable {
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public CDLib() {}
	public CDLib(String cdNo, String cdTitle, String bookNo) {
		super(cdNo, cdTitle, bookNo);
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
		System.out.println("\""+getCdTitle()+"\"이(가) 대출되었습니다.");
		System.out.println("[대출인]"+borrower);
		System.out.println("[대출일]"+checkOutDate);
	}
	@Override
	public void checkIn() {
		if(state != STATE_NORMAL) {	//대출 중이었음
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("\""+getCdTitle()+"\""+"이(가) 반납되었습니다.");
			return;
		}
		//대출기록이 없음 -> 반납불가
		System.out.println("시스템오류");
	}
	@Override
	public void printState() {
		String msg = getCdNo() + "\t\""+getCdTitle()+"\"";
		msg += (getBookNo()==null)? "(단독CD)" : "("+getBookNo()+")";
		msg = msg + ((state==STATE_NORMAL) ? "\t대출가능" : (state==STATE_BORROWED)? "\t대출중" : "시스템오류");
		System.out.println(msg);
	}
	public byte getState() {
		return 0;
	}
	
}
