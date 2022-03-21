package com.lec.ex08_superdot;
//ParentClass - i(private), method(), getI()
//ChildClass - i(private), method(), getI()
public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		System.out.println(child.getI());
		child.method();
	}
}
