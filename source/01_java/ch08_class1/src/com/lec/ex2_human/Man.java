package com.lec.ex2_human;
//Man kim = new Man(22, 160, 50.2, "010-9999-9999");
//Man kim = new Man(22, 160, 50.2);
//Man kim = new Man(22);
public class Man {	//main�Լ��� ��� JVM����X
	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	public Man() {}	//����Ʈ ������ �Լ�
	
//	3��¥��
	public Man(int age) {
		this.age = age;
		System.out.println("�Ķ���Ͱ� 1��¥�� ������ �Լ� ȣ��");
	}	
//	3��¥��
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("�Ķ���Ͱ� 3��¥�� ������ �Լ� ȣ��");
	}
//	4��¥��	
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("�Ķ���Ͱ� 4��¥�� ������ �Լ� ȣ��");
	}
//	�޼ҵ�
	public double calculateBMI() {
		double result = weight / ((height/100.0)*(height/100.0));
		return result;
	}
//	setter(age, height, weight, phoneNum)
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
//	getter(age, height, weight, phoneNum)
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;		
	}
	public double getWeight() {
		return weight;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
}
