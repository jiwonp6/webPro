package com.lec.ex07_book1;
//Book b = new Book("890��-1010-1��", "java", "ȫ�浿")
public class Book implements Ilendable {
	private String requestNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte state;	//����Ұ�(1), ���Ⱑ��(0)
	
	public Book(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
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
		System.out.println("\""+bookTitle+"\"��(��) ����Ǿ����ϴ�.");
		System.out.println("[������]"+borrower);
		System.out.println("[������]"+checkOutDate);
	}
	@Override
	public void checkIn() {	//�ݳ�ó�� �� �ٽ� null������ 
		if(state != STATE_NORMAL) {	//���� ���̾���
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("\""+bookTitle+"\""+"��(��) �ݳ��Ǿ����ϴ�.");
			return;
		}
		//�������� ���� -> �ݳ��Ұ�
		System.out.println("�ý��ۿ���");
	}
	@Override
	public void printState() {
		//���׿�����
		String msg = requestNo + "\t\""+bookTitle+"\""+"("+writer+"��)\"t";
		msg = msg + ((state==STATE_NORMAL) ? "���Ⱑ��" : (state==STATE_BORROWED)? "������" : "�ý��ۿ���");
		System.out.println(msg);
		//if��
//		if(state==STATE_NORMAL) {
//			System.out.println("���Ⱑ��");
//		}else if(state==STATE_BORROWED) {
//			System.out.println("������");
//		}else {
//			System.out.println("�ý��ۿ���");
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
