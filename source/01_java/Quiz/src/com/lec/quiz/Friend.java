package com.lec.quiz;

public class Friend {
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public Friend() {}
	
	public Friend(String name, String address, String phone, String birthday) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		String str = "�� �� : "+name+"\n�� �� : "+address+"\n�ڵ��� : "+phone+"\n�� �� : "+birthday+"\n";
		return str;
	}
	public String getAddress() {
		return address;
	}
}
