package com.lec.ex05_lib;

public interface ILendable {
	public /*static final(��������)*/ byte STATE_BORROWED = 1;		//������
	public byte STATE_NORMAL = 0;	//���Ⱑ��
	public void checkOut(String borrower) throws Exception;	//����޼ҵ�
	public void checkIn() throws Exception;	//�ݳ��޼ҵ�
}
