package com.lec.ex05_lib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // 대출 중
	public byte STATE_NORMAL = 0; // 대출 가능상태
	
	public void checkOut(String borrower) throws Exception; // 대출 , 예외처리할 메소드라서 throws Exception 해주기
	
	public void checkIn() throws Exception; // 반납 , 예외발생할수 있는 메소드
	
		
}
