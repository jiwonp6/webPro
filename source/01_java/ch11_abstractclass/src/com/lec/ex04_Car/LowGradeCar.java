package com.lec.ex04_Car;
//color, tire, displacement, handle, getSpec(추상메소드)에서 추가할 데이터 : tax
//Car c = new LowGrandeCar("빨강", "광폭", 1490, "파워")
public class LowGradeCar extends Car {
	private int tax;
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000;
	}
	@Override
	public void getSpec() {	//spec들(색상, 타이어, 배기량, 핸들, 세금)을 출력
		if(getDisplacement() > 1000) {
			tax +=(getDisplacement()-1000)*100;
		}
		System.out.println("색  상 : "+getColor());
		System.out.println("타이어 : "+getTire());
		System.out.println("배기량 : "+getDisplacement());
		System.out.println("핸  들 : "+getHandle());
		System.out.println("세  금 : "+tax);
		System.out.println("------------------");
	}
}
