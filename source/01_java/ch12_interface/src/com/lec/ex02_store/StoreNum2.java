package com.lec.ex02_store;
//���а��� ����2ȣ��: ��ġ�-5,000  �δ��-5,000  �����-5,000 ���뱹-5,000  �����-����
public class StoreNum2 implements HeadQuarterStore{	//�Ű����� ���� ������ ���ٰ� ����
	private String str;
	//������
	public StoreNum2(String str) {
		this.str = str;
	}
	//override
	@Override
	public void kimchi() {
		System.out.println("��ġ� 5,000��");
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
	public void sunde() {
		System.out.println("���� 5,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("������� ����");
	}
	//getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
