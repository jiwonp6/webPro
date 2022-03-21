package com.lec.ex09_super;
//Person p = new Person("홍길동", "착해");
public class Person {
	private String name;
	private String character;
	//매개변수 없는 생성자
	public Person() {
		System.out.println("매개변수(=파라미터 =인자)가 없는 Person 생성자");
	}
	//매개변수 2개짜리 생성자
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수 2개짜리 Person 생성자");
	}
	public void intro() {
		System.out.println(name+"은(는) "+character);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
