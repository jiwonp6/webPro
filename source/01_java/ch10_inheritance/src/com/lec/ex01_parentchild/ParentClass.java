package com.lec.ex01_parentchild;

public class ParentClass {	//�ڿ� extends of�� �����Ǿ�����
	String pStr = "�θ�Ŭ����";		//public�̶� �ٸ�
	public ParentClass() {
		System.out.println("�θ� Ŭ���� ��ü �κ� ����");
	}
	public void getPapaName() {
		System.out.println("�ƺ��̸� : ������");
	}
	public void getMamiName() {
		System.out.println("�����̸� : ������");
	}
}
