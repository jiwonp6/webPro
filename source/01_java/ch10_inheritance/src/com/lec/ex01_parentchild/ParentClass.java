package com.lec.ex01_parentchild;

public class ParentClass {	//뒤에 extends of가 생략되어있음
	String pStr = "부모클래스";		//public이랑 다름
	public ParentClass() {
		System.out.println("부모 클래스 객체 부분 생성");
	}
	public void getPapaName() {
		System.out.println("아빠이름 : 박지성");
	}
	public void getMamiName() {
		System.out.println("엄마이름 : 박지원");
	}
}
