package com.lec.ex02;

public class TestMain2 {
	public static void main(String[] args) {
	//SuperClass s = new SuperClass();	//추상클래스를 이용한 객체 생성 불가
	//ChildClass2 c = new ChildClass2();
	ChildClass2 g = new GrandChild();
	g.method1();
	g.method2();
	}	
}
