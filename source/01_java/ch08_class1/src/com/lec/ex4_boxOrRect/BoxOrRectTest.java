package com.lec.ex4_boxOrRect;

public class BoxOrRectTest {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10, 5);
		box.vPrint();
		System.out.println("\n박스 부피는" + box.getVolume());
		System.out.println("\nrect 넓이는" + box.getVolume());
		
	}
}
