package com.lec.ex07_book1;
//book 작업명세서
public interface Ilendable {
	public byte STATE_BORROWED = 1;	//대출 중, 대출 불가
	public byte STATE_NORMAL = 0;	//대출 가능
	public void checkOut(String borrower, String checkoutDate);	//대출시 대출인과 대출일 이용
	public void checkIn();	//반납
	public void printState();	//도서정보와 대출 상태 출력
}
