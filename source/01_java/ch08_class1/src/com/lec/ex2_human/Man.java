package com.lec.ex2_human;
//Man kim = new Man(22, 160, 50.2, "010-9999-9999");
//Man kim = new Man(22, 160, 50.2);
public class Man {	//main함수가 없어서 JVM실행X
	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	public Man() {}	//디폴트 생성자 함수
	
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		
		System.out.println("파라미터가 4개짜리 생성자 함수 호출");
	}
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		
		System.out.println("파라미터가 3개짜리 생성자 함수 호출");
	}
	
}
