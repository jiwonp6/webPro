package com.lec.ex01_store;

public abstract class HeadQuarterStore {	//abstract <- �߻� Ŭ������ ����
	//����
	private String str;	
	public HeadQuarterStore(String str) {
		//super();	//object�� ���� ��ӹ��� ����Ʈ������
		this.str = str;
	}
	//�޼ҵ� ������ ���� ���� ���ִ� �޼ҵ� : �߻�޼ҵ�(��ӹ��� Ŭ�������� �������̵�) <- ��ü ���� �Ұ���
		// -> Ŭ���� �� �߻� �޼ҵ尡 �ϳ� �̻��� �� : �߻�Ŭ����
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gonggibab();
	//getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
