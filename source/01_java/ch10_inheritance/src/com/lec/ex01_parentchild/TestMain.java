package com.lec.ex01_parentchild;

public class TestMain {
	public static void main(String[] args) {	//상속받은 class 먼저가서 먼저 만듦
		ChildClass child = new ChildClass();	
		child.getMamiName();
		child.getPapaName();
		System.out.println(child.pStr);
	}
}
