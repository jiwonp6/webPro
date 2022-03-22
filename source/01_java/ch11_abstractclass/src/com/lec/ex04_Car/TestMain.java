package com.lec.ex04_Car;

import com.lec.cons.CarSpec;

public class TestMain {
	public static void main(String[] args) {
//		Car car = new LowGradeCar(CarSpec.RED_CAR, CarSpec.TIRE_NORMAL, 
//										CarSpec.DISPLACEMENT_1000, CarSpec.HANDLE_NORMAL);
		Car car = new HighGradeCar(CarSpec.WHITE_CAR, CarSpec.TIRE_WIDE, 
										CarSpec.DISPLACEMENT_2200, CarSpec.HANDLE_POWER);
	car.getSpec();
	}
}
