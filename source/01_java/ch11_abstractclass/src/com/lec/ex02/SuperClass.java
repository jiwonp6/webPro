package com.lec.ex02;

public abstract class SuperClass {
	public abstract void method1();	//추상메소드; 상속받은 클래스에서 구현(오버라이드)
	public void method2() {	//일반메소드
		System.out.println("SuperClass의 method2");
	}
}
