package com.lec.ex05;

public class Child1 extends Super {
	int c1;

	public Child1() {
		System.out.println("Child형 객체 생성");
	}
	public Child1(int c1) {
		System.out.println("Child형 객체 생성(매개변수)");
		this.c1 = c1;
	}
	
}
