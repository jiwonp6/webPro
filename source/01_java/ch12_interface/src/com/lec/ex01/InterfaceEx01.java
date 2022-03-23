package com.lec.ex01;
//오직 상수(final 변수)랑 추상메소드만 가능
public interface InterfaceEx01 {
	public /*static final*/ int CONSTANT_NUM = 10;	//외부에서도 쓸 수 있게 무조건 public
		//(interface에선 생략가능)
	public /*abstract*/ void method1();
		//(interface에선 생략가능)
	


}
