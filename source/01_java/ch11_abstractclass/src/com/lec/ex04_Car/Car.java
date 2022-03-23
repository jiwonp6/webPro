package com.lec.ex04_Car;
//color, tire, displacement, handle, getSpec()
public abstract class Car {
	private String color;
	private String tire;	//타이어
	private int displacement;	//배기량
	private String handle;	//핸들
	//생성자
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	public abstract void getSpec();
	//getter&setter
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTire() {
		return tire;
	}
	public void setTire(String tire) {
		this.tire = tire;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
}
