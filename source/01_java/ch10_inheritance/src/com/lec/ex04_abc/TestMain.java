package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S s = new S();
//			A a = new A();
//			B b = new B();
//			A c = new C();
		S a = new A();	// ��� ---> (�迭����ϱ� ����)�ϳ��� Ÿ������ ��ȯ����
		S b = new B();
		S c = new C();
		S[] arr= {s, a, b, c};
		for(S obj : arr) {
			System.out.print(obj.s+"\t");
		}
		
	}
}
