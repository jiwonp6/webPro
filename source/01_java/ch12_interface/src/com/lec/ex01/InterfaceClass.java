package com.lec.ex01;
//CONSTANT_NUM, CONSTANT_STRING, method1(�߻�), method2(�߻�)
public class InterfaceClass implements InterfaceEx01, InterfaceEx02{

	@Override
	public void method1() {
		System.out.println("���� ������ implements ���� Ŭ�������� �ؿ�. method1");
	}
	@Override
	public String method2() {
		System.out.println("���� ������ implement�� Ŭ�������� �ؿ�. method2");
		return null;
	}
	
}
