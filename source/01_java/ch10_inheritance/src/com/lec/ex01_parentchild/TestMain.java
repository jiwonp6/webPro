package com.lec.ex01_parentchild;

public class TestMain {
	public static void main(String[] args) {	//��ӹ��� class �������� ���� ����
		ChildClass child = new ChildClass();	
		child.getMamiName();
		child.getPapaName();
		System.out.println(child.pStr);
	}
}
