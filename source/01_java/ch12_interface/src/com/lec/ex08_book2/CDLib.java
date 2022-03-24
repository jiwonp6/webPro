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
			System.out.println("����Ұ�");
			return;	// ����Ұ��̸� �ٷ� �ý��� �ߴ��ϰ� ��������(else�Ƚᵵ ��, void�� ���� ���� �ȵǰ� ���ϸ� ���� ����)
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println("\""+getCdTitle()+"\"��(��) ����Ǿ����ϴ�.");
		System.out.println("[������]"+borrower);
		System.out.println("[������]"+checkOutDate);
	}
	@Override
	public void checkIn() {
		if(state != STATE_NORMAL) {	//���� ���̾���
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("\""+getCdTitle()+"\""+"��(��) �ݳ��Ǿ����ϴ�.");
			return;
		}
		//�������� ���� -> �ݳ��Ұ�
		System.out.println("�ý��ۿ���");
	}
	@Override
	public void printState() {
		String msg = getCdNo() + "\t\""+getCdTitle()+"\"";
		msg += (getBookNo()==null)? "(�ܵ�CD)" : "("+getBookNo()+")";
		msg = msg + ((state==STATE_NORMAL) ? "\t���Ⱑ��" : (state==STATE_BORROWED)? "\t������" : "�ý��ۿ���");
		System.out.println(msg);
	}
	public byte getState() {
		return 0;
	}
	
}
