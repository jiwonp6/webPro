package com.lec.quiz;

public class Person {
	private String name;
	private String tel;
	private int age;
	
	public Person() {}

	public Person(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	@Override
	public String toString() {
		return name+"\t"+tel+"\t\t"+age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
