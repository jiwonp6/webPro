package com.lec.ex08_book2;
//book �۾�������
public interface Ilendable {
	public byte STATE_BORROWED = 1;	//���� ��, ���� �Ұ�
	public byte STATE_NORMAL = 0;	//���� ����
	public void checkOut(String borrower, String checkoutDate);	//����� �����ΰ� ������ �̿�
	public void checkIn();	//�ݳ�
	public void printState();	//���������� ���� ���� ���
}