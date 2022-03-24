package com.lec.ex08_book2;
//boolean�־ cd���� å���� �̸� true false�� ���� �� ����.
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
			System.out.println("����Ұ�");
			return;	// ����Ұ��̸� �ٷ� �ý��� �ߴ��ϰ� ��������(else�Ƚᵵ ��, void�� ���� ���� �ȵǰ� ���ϸ� ���� ����)
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println("\""+getBookTitle()+"\"��(��) ����Ǿ����ϴ�.");
		System.out.println("[������]"+borrower);
		System.out.println("[������]"+checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state != STATE_NORMAL) {	//���� ���̾���
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("\""+getBookTitle()+"\""+"��(��) �ݳ��Ǿ����ϴ�.");
			return;
		}
		//�������� ���� -> �ݳ��Ұ�
		System.out.println("�ý��ۿ���");
	}

	@Override
	public void printState() {
		String msg = getRequestNo() + "\t\""+getBookTitle()+"\""+"("+getWriter()+"��)\t";
		msg = msg + ((state==STATE_NORMAL) ? "���Ⱑ��" : (state==STATE_BORROWED)? "������" : "�ý��ۿ���");
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
