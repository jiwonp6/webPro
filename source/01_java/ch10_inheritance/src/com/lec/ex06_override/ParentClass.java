package com.lec.ex06_override;

public class ParentClass {

	public ParentClass() {	//overloading = �Լ� �ߺ� ����(�Ű������� ���� Ÿ���� �޸�)
		System.out.println("�Ű����� ���� ParentClass ������");
	}
	public ParentClass(int i) {
		System.out.println("�Ű����� �ִ� ParentClass ������");
	}
	public void method1() {
		System.out.println("ParentClass�� method1() �Լ�");
	}
	public void method2() {
		System.out.println("ParentClass�� method2() �Լ�");
	}
}
