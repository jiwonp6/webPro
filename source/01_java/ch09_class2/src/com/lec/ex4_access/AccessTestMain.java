package com.lec.ex4_access;

import com.lec.ex3_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();	
		// = com.lec.ex3_access.AccessTest obj;
		//static 메소드로 하면 ---> 클래스 설계도에 생겨서 거기서 바로 실행
		System.out.println(obj.publicMember);
		//private, 
			//default(같은 패키지 내에서만 쓸 수 있음), 
				//protected(같은 패키지 내거나 상속받으면 쓸 수 있음) 못씀
		obj.publicMethod();
	}
}
