package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		SuperClass obj = new ChildClass();	//���� ������ �Ұ��� ���� ������ ����
		obj.method1();
		obj.method2();
//		SuperClass s = new SuperClass() {
//			@Override
//			public void method1() {
//				System.out.println("�͸�Ŭ���� ����");
//			}	
//		};
//		s.method1();
	}
}
