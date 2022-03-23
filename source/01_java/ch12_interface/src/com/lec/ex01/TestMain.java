package com.lec.ex01;
//하나지만 여러가지 성질 -> 다형성
public class TestMain {
	public static void main(String[] args) {
		//InterfaceEx01 ex01 = new InterfaceEx01();	//---> 인터페이스 객체 생성 불가능
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		System.out.println(obj1.CONSTANT_NUM+"/"+obj1.CONSTANT_STRING); 	
		//객체 변수로 static access비추
		System.out.println(InterfaceEx01.CONSTANT_NUM+"/"+InterfaceEx02.CONSTANT_STRING); 	
		//객체 변수로 인터페이스 변수로 호출
		InterfaceEx01 obj2 = new InterfaceClass();
		obj2.method1();
		//obj2.method2();	
		// ---> InterfaceEx01에서 불러왔기 때문에 obj2에 method2가 있어도 형변환 필요
		if(obj2 instanceof InterfaceClass) {
			((InterfaceClass) obj2).method2();	//<--- 형변환
		}
		System.out.println(obj2.CONSTANT_NUM);
		//System.out.println(obj2.CONSTANT_STRING);	//<--- 위와 마찬가지로 불가능
		InterfaceEx02 obj3 = new InterfaceClass ();
		//obj3.method1();	<--- 불가능
		obj3.method2();
	}
}
