package com.lec.ex;
//class : ������(�Ӽ�, �ν��Ͻ�����)�� �޼ҵ�(���, setter, getter<-������ �������)
//Car c = new Car()
//c.park()
public class Car {						//class
	private String color;	//����
	private int cc;	//��ⷮ	
	private int speed;	//�ӵ�
	public void drive( ) {				
		speed = 60;
		System.out.println(color + "�� ���� �����Ѵ�.\n���� �ӵ� : " + speed);
	}
	public void park() {		
		speed = 0;
		System.out.println(color + "�� ���� �����Ѵ�.\n���� �ӵ� : " + speed);
	}
	public void race() {		
		speed = 120;
		System.out.println(color + "�� ���� �����Ѵ�.\n���� �ӵ� : " + speed);
	}
//	<setter> <---- (color, cc, speed)
	//myPorsche.methodName("red") set+color => setColor
	public void setColor(String color) {
		this.color = color; //this.color�� ���� �� ��ü�� color, color�� �Էµ� ��
	}
//	public void setCc(int cc) {	//myPorsche.setCc(1500)
//		this.cc = cc;
//	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
//	<getter>
	//myPorsche.getColor()
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
}
