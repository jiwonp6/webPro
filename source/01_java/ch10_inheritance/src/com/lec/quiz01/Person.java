package com.lec.quiz01;

public class Person {
	private String id;
	private String name;
	
	public Person() {}
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}	
	//getter&setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

