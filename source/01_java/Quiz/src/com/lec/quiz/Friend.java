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
		String str = "이 름 : "+name+"\n주 소 : "+address+"\n핸드폰 : "+phone+"\n생 일 : "+birthday+"\n";
		return str;
	}
	public String getAddress() {
		return address;
	}
}
