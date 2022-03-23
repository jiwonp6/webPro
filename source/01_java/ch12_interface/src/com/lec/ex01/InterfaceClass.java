package com.lec.ex01;
//CONSTANT_NUM, CONSTANT_STRING, method1(추상), method2(추상)
public class InterfaceClass implements InterfaceEx01, InterfaceEx02{

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements 받은 클래스에서 해요. method1");
	}
	@Override
	public String method2() {
		System.out.println("실제 구현은 implement한 클래스에서 해요. method2");
		return null;
	}
	
}
