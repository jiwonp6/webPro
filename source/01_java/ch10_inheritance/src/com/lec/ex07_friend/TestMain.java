package com.lec.ex07_friend;

public class TestMain {
	public static void main(String[] args) {
		Friend f1 = new Friend();
		System.out.println(f1.infoString());
		Friend f2 = new Friend("박지원");
		System.out.println(f2.infoString());
		Friend f3 = new Friend("박지원", "010-9999-9999");
		System.out.println(f3.infoString());
	}
}
