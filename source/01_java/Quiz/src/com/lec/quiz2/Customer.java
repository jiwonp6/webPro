package com.lec.quiz2;

import java.util.Date;

public class Customer {
	private String name;
	private String tel;
	private String birth;
	private String address;
	
	public Customer() {}
	public Customer(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	@Override
	public String toString() {
		return name+"\t"+tel+"\t"+birth+"\t"+address;
	}
	
	
	
	
}
