package com.lec.ex02_store;
//���ǰ��� ����3ȣ��: ��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000  �����-1,000��
public class StoreNum3 implements HeadQuarterStore{	//�Ű����� ���� ������ ���ٰ� ����
	private String str;
	//������
	public StoreNum3(String str) {
		this.str = str;
	}
	//override
	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 7,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� 7,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���� 6,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� 1,000��");
	}
	//getter&setter
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
