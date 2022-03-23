package com.lec.ex05_test;
//물려받은 것 : i1, i2, i3, i11, m1(일반), m2(일반), m3(일반), m11(추상)
//i1, i2, i3, i11, m1(일반), m2(일반), m3(일반), m11(일반)	<---오버라이드하면 일반이 됨
public class TestChildClass extends TestClass implements I11 {

	@Override
	public void m11() {
		System.out.println("상수 i11 = " + i11);	//I11.i11
	}

}
