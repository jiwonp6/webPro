package com.lec.ex;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();	//myPorsche�� ��ü
		myPorsche.setColor("red");  //myPorsche.color = "red";	// setter
		System.out.println(myPorsche.getColor()
					+"\n��ⷮ : "
					+myPorsche.getCc()
					+"\n�ӵ� : "+myPorsche.getSpeed());	// getter
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getSpeed());
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
	}
}
