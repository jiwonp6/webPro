package com.lec.ex0_parkingSystem;

public class ParkingSystemMain {
	public static void main(String[] args) {
		ParkingSystem p1 = new ParkingSystem("22��2222", 14);
		ParkingSystem p2 = new ParkingSystem("11��1111", 14);
		
		p1.out();	//����ڿ��� outTime�ޱ�
		p2.out(18);	//outTime 18�� �����ؼ� �ޱ�
	}
}
