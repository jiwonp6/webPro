package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		SuperClass obj = new ChildClass();	//변수 생성은 불가능 변수 파일은 가능
		obj.method1();
		obj.method2();
//		SuperClass s = new SuperClass() {
//			@Override
//			public void method1() {
//				System.out.println("익명클래스 생성");
//			}	
//		};
//		s.method1();
	}
}
