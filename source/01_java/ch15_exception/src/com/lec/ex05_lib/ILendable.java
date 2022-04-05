package com.lec.ex05_lib;

public interface ILendable {
	public /*static final(생략가능)*/ byte STATE_BORROWED = 1;		//대출중
	public byte STATE_NORMAL = 0;	//대출가능
	public void checkOut(String borrower) throws Exception;	//대출메소드
	public void checkIn() throws Exception;	//반납메소드
}
