package com.lec.ex06_override;
//ParentClass�� method1(), method2()��� ����
public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	public void method3() {
		System.out.println("ChildClass�� method3() �Լ�");
	}
//	public void method1() {
//		System.out.println("ChildClass�� method1() �Լ�");
//	}
	//����Ű�� �������̵� �̿�	
	@Override
	public void method1() {
		System.out.println("ChildClass�� method1() �Լ�");
	}
	//equals(ParentClass�� method1 �������̵�)
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
}
