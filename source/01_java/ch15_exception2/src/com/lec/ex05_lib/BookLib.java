package com.lec.ex05_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo; // å ��ȣ
	private String bookTitle; // å �̸�
	private String writer; // ����
	private String borrower; // ������
	private Date checkOutDate; // ������
	private byte state; // ������ (1) or ���Ⱑ��(0)

	public BookLib() {
	}

	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	// ��������Ȯ�� -> ������� -> �����������
	@Override
	public void checkOut(String borrower) throws Exception {
		if (state == STATE_BORROWED) {
			throw new Exception(bookTitle + " ������ �ڴ����ߡ� �Դϴ�."); // ������ ���� �߻�
		}
		// ���� ����
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		// java ������ ����Ǿ����ϴ�. ������ : �ű浿 ������: 2022-4-4 2���̳��� �ݳ��ϼ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		System.out.println("\"" + bookTitle + "\" ������ ����Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + " / ������ : " + sdf.format(checkOutDate) + "2�ֳ��� �ݳ��ϼ���.");
	}

	// book.checkIn() : �������� Ȯ�� -> ��ü���� Ȯ�� -> (if. ��ü�Ǿ������ ��ü�� ���� y/n) -> �ݳ����� ->
	// �������
	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception(bookTitle + " ������ �������� �ƴϿ���");
		}
		// ��ü���� Ȯ�� checkOutDate ~ ������� 14�� �̳����� ����
		Date now = new Date();
		long diff = (now.getTime()) - (checkOutDate.getTime());
		long day = diff / (1000 * 60 * 60 * 24);
		if (day > 14) { // ��ü ���� 14���� ũ�� ��ü
			System.out.println("��ü��� ���� 100�� �ΰ��˴ϴ�. ���ž��� ��ü��� : "+(day-14)*100 +" �� �Դϴ�.");
			Scanner sc = new Scanner(System.in);
			System.out.print("��ü�Ḧ ���̳���? ( Y/N ) : ");
			if( ! sc.next().equalsIgnoreCase("y")) { // ��ü�Ḧ �´ٰ� y�� �Է����� ������� 
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �����մϴ�. ��ü�Ḧ ������.");
				return;
			}
		} // ��ü �ȵȰ�� �ݳ����� 
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\"������ �ڹݳ��� �Ǿ����ϴ�. ");

	}
	// sysout(book)  - > å��ȣ , å�̸�, ���� , ���Ⱑ�� ��� 
	//               - > å��ȣ, å�̸�, ����, ������( ������ ) ���
	@Override
	public String toString() {
		String msg = "å ��ȣ : "+ bookNo + " å �̸� : "+ bookTitle + " ���� : "+ writer;		
		msg += (state == STATE_NORMAL) ? "\t���Ⱑ��" : "\t������";
		if(state == STATE_BORROWED) {
			// �������� + 14���� �� ��¥ �� date = �ݳ�������
//			Date date = new Date(checkOutDate.getTime() + (1000*60*60*24*14)); 
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
			SimpleDateFormat sdf = new SimpleDateFormat(" ( ������ : yyyy-MM-dd(E))");
//			msg += sdf.format(date);
			msg += sdf.format(checkOutDate);
		}
		return msg;
		
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	

}
