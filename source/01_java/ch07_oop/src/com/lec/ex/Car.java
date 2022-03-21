package com.lec.ex;
//class : 데이터(속성, 인스턴스변수)와 메소드(기능, setter, getter<-데이터 갖고와줌)
//Car c = new Car()
//c.park()
public class Car {						//class
	private String color;	//색상
	private int cc;	//배기량	
	private int speed;	//속도
	public void drive( ) {				
		speed = 60;
		System.out.println(color + "색 차를 운전한다.\n지금 속도 : " + speed);
	}
	public void park() {		
		speed = 0;
		System.out.println(color + "색 차를 주차한다.\n지금 속도 : " + speed);
	}
	public void race() {		
		speed = 120;
		System.out.println(color + "색 차를 운전한다.\n지금 속도 : " + speed);
	}
//	<setter> <---- (color, cc, speed)
	//myPorsche.methodName("red") set+color => setColor
	public void setColor(String color) {
		this.color = color; //this.color는 현재 내 객체의 color, color는 입력된 색
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
