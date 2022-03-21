package com.lec.ex08_superdot;

public class ChildClass extends ParentClass{	//ParentClass - i, method()
	private int i = 99;

	public ChildClass() {
		System.out.println("ChildClass 생성자");
	}
	@Override
	public void method() {
		System.out.println("ChildClass의 method");
		super.method();
		System.out.println("ChildClass에서 super의 i = " + super.getI()+", Child단의 i = " + i);
	}
	@Override
	public int getI() {
		return i;	//child단의 i를 반환함, super.getI()로 하면 Parent단의 i를 반환
	}
}
