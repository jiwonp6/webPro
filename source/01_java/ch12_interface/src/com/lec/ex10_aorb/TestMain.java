package com.lec.ex10_aorb;

public class TestMain {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		User user = new User();
		user.use(a);
		user.use(b);
	}
}
