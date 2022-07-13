package com.lec.ch03.ex1;

import java.util.ArrayList;

import lombok.Data;
@Data
public class Student {
	private String name;
	private int age;
	private ArrayList<String> hobby;
	private double height;
	private double weight;
	
	//매개변수 3개인 생성자 함수(따로 만들어야 함)
	public Student(String name, int age, ArrayList<String> hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	
}
