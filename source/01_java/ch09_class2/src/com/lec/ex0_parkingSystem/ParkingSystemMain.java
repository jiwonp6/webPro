package com.lec.ex0_parkingSystem;

public class ParkingSystemMain {
	public static void main(String[] args) {
		ParkingSystem p1 = new ParkingSystem("22로2222", 14);
		ParkingSystem p2 = new ParkingSystem("11라1111", 14);
		
		p1.out();	//사용자에게 outTime받기
		p2.out(18);	//outTime 18로 지정해서 받기
	}
}
