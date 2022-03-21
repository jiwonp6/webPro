package com.lec.ex;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();	//myPorsche가 객체
		myPorsche.setColor("red");  //myPorsche.color = "red";	// setter
		System.out.println(myPorsche.getColor()
					+"\n배기량 : "
					+myPorsche.getCc()
					+"\n속도 : "+myPorsche.getSpeed());	// getter
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getSpeed());
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
	}
}
