package com.lec.ex;
//빈태그 사용하려면 : 매개변수없는생성자, setter, getter
public class Person {
	private String name;	//"홍길동"
	private int age;
	private char gender;	//'f'
	private String address;
	//생성자
	public Person() { }
	//dao, dto만들꺼 아니라서 없어도 됨
	public Person(String name, int age, char gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	//게터&세터
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
