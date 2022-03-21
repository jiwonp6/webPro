package com.lec.ex07_friend;
//this. : 내 객체의 
//this() : 현 클래스의 생성자 함수
public class Friend {
	private String name;
	private String tel;
	//"010-9999-9999" Friend f = new Friend("홍길동", "010-9999-9999")
	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("매개변수 하나짜리 생성자 함수");
	}
	public Friend(String name, String tel) {
		this(name);	//Friend(name)호출
		this.tel = tel;
		System.out.println("매개변수 두개짜리 생성자 함수");
	}
	public String infoString() {
		return "[이름]"+name+"[전화]"+tel;
	}
}
