package com.lec.ex08_superdot;

public class ChildClass extends ParentClass{	//ParentClass - i, method()
	private int i = 99;

	public ChildClass() {
		System.out.println("ChildClass ������");
	}
	@Override
	public void method() {
		System.out.println("ChildClass�� method");
		super.method();
		System.out.println("ChildClass���� super�� i = " + super.getI()+", Child���� i = " + i);
	}
	@Override
	public int getI() {
		return i;	//child���� i�� ��ȯ��, super.getI()�� �ϸ� Parent���� i�� ��ȯ
	}
}
