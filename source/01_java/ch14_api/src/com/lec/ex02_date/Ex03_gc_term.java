package com.lec.ex02_date;

import java.util.GregorianCalendar;

public class Ex03_gc_term {
	public static void main(String[] args) {
		GregorianCalendar gcNow = new GregorianCalendar();	//���� ������ ��¥�� �ð�
		GregorianCalendar gcThat = new GregorianCalendar(2022, 3, 11, 9, 30);	//���� ������ ��¥�� �ð�
		long start = gcThat.getTimeInMillis();	//1970��~�������� ������ �и�����
		long end = gcNow.getTimeInMillis();	//1970��~���� ������ �и�����
		int day = (int)(end-start)/(1000*60*60*24);
		System.out.println("�����Ϻ��� ������� ���� ��������"+day);
	}
}
