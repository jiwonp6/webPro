package com.lec.ex12_store;
//���ð��� ����1ȣ��: �δ��-5,000  ����-���Ⱦ�
public class StoreNum1 extends HeadQuarterStore{	//�Ű����� ���� ������ ���ٰ� ����

	public StoreNum1(String str) {
		super(str);
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���� ����");
	}
}
