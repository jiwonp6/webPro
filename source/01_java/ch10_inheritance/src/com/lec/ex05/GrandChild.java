package com.lec.ex05;

public class GrandChild extends Child1 {
	int gc;
	public GrandChild() {
		System.out.println("GrandChild형 객체 생성");
	}
	public GrandChild(int gc) {
		System.out.println("GrandChild형 객체 생성(매개변수)");
		this.gc = gc;
	}
}
