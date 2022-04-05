package com.lec.quiz;

public class Member {
	private String name;
	private String tel;
	private String address;
	private String id = tel+address;
	
	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return name+"\t"+tel+"\t"+address+"\n";
	}
	
}
