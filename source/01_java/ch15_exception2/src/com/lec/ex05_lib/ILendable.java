package com.lec.ex05_lib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // ���� ��
	public byte STATE_NORMAL = 0; // ���� ���ɻ���
	
	public void checkOut(String borrower) throws Exception; // ���� , ����ó���� �޼ҵ�� throws Exception ���ֱ�
	
	public void checkIn() throws Exception; // �ݳ� , ���ܹ߻��Ҽ� �ִ� �޼ҵ�
	
		
}
