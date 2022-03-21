package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S s = new S();
//			A a = new A();
//			B b = new B();
//			A c = new C();
		S a = new A();	// 상속 ---> (배열사용하기 위해)하나의 타입으로 변환해줌
		S b = new B();
		S c = new C();
		S[] arr= {s, a, b, c};
		for(S obj : arr) {
			System.out.print(obj.s+"\t");
		}
		
	}
}
