package com.lec.ex4_personInfo;
//name, age, gender
public class PersonInfo {
	private String name;
	private int age;
	private char gender;
	
	public PersonInfo() {}
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
//�޼ҵ�	
	public void print() {
		System.out.printf("�̸�=%s, ����=%d, ����=%c\n", name, age, gender);
	}
	
//setter&getter	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
