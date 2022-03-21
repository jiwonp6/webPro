package com.lec.ex02_protectedmember;

public class TestMain {
	public static void main(String[] args) {
		Child child = new Child(1, 2);
		System.out.println("child¿« i : " + child.getI());
		System.out.println("child¿« j : " + child.getJ());
		child.setI(10); child.setJ(20);
		child.sum();
	}
}
