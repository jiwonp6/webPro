package com.lec.ex12_store;
//���а��� ����2ȣ��: �δ��-5,000 �����-5,000 �����-����
public class StoreNum2 extends HeadQuarterStore{	//�Ű����� ���� ������ ���ٰ� ����

	public StoreNum2(String str) {
		super(str);
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("������� ����");
	}
}
