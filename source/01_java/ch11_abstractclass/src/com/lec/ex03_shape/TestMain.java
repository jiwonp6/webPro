package com.lec.ex03_shape;

public class TestMain {
	public static void main(String[] args) {
		Shape[] shape = {new Rectangle(10, 5), new Triangle(10,8), new Circle(6)};
		for(Shape s : shape) {
			s.draw();
			s.computeArea();
			System.out.println("계산된 넓이는 "+s.computeArea());
		}
	}
}
