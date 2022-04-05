package com.lec.ex05_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkoutDate;
	private byte state;	//������(1) or ���Ⱑ��(0)
	
//������	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	//BookLib book = new BookLib("89a-01", "java", "ȫ�浿");
	//book.CheckOut("�ű浿") : �������� Ȯ�� -> ������� -> �����������
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state==STATE_BORROWED) {
			throw new Exception(bookTitle +"������ *������* �Դϴ�.");	//������ ���� �߻�
		}
		//�������
		this.borrower = borrower;
		checkoutDate = new Date();
		state = STATE_BORROWED;
		//java ������ ����Ǿ����ϴ�. ������ : �ű浿 ������ : 2022-04-04(2�ֳ��� �ݳ��ϼ���.)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		System.out.println("\""+bookTitle+"\" ������ ����Ǿ����ϴ�.");
		System.out.println("������ : "+borrower+"/������ : "+sdf.format(checkoutDate)+"(2�ֳ��� �ݳ��ϼ���.)");
	}
	//book.checkIn() : �������� Ȯ�� -> ��ü���� Ȯ�� -> (if. ��üO : ��ü�ᳳ��y/n) -> �ݳ����� -> �������
	@Override
	public void checkIn() throws Exception {
		 if(state==STATE_NORMAL) {
			 throw new Exception(bookTitle +"������ �������� �ƴմϴ�.");
		 }
		 //��ü���� Ȯ�� checkOutDate ~ ������� 14���̳����� ���� Ȯ��
		Date now = new Date();
		long diff = now.getTime() - checkoutDate.getTime();	//����������� ��������� �и�������
		long day = diff/(1000*60*60*24);
		//��ü���� Ȯ��
		if(day > 14) {	//��üO
			System.out.println("<��ü��� ���� 100�� �ΰ��˴ϴ�> \n���ž��� ��ü��� "+(day-14)*100+"��");
			Scanner sc = new Scanner(System.in);
			System.out.println("��ü�Ḧ �����ϼ̳���?(y/n)");
			if(! sc.next().equalsIgnoreCase("y")) {	//��ü�Ḧ �´ٰ� y(Y)�� �Է��������� ���
				System.out.println("��ü�Ḧ �����ϼž� �ݳ�ó���� �����մϴ�. ��ü�Ḧ �������ּ���.");
				return;	//void�̹Ƿ� return�� �����.
			}
		}
		//��üX -> �ݳ����� �ٷ� ����
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"������ *�ݳ�*�Ǿ����ϴ�.");
//toString
	}
	//sysout(book) -> å��ȣ:89��-01 å�̸�:java ����:ȫ�浿 ���Ⱑ��
	//			   -> å��ȣ:89��-01 å�̸�:java ����:ȫ�浿 ������(������:2022-04-18(��))
	@Override
	public String toString() {
		String msg = "å��ȣ:"+bookNo+" å�̸�:"+bookTitle+" ����:"+writer;
		msg += (state == STATE_NORMAL) ? " (���Ⱑ��) " : " (������) ";
		if(state == STATE_BORROWED) {
			//�������� + 14��
			SimpleDateFormat sdf = new SimpleDateFormat("������:yyyy-MM-dd(E)");
			msg += sdf.format(checkoutDate);
		}
		return msg;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
}

