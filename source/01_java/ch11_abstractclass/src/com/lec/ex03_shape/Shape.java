package com.lec.ex03_shape;
//Shape를 통해 Rectangle(w,h), Traiangle(w,h), Circle(r)를 잘 쓰고자 함
public abstract class Shape {
	public void draw() {
		String className = this.getClass().getName();	// com.lec.es03_shape.Circle
														// com.lec.ex03_shape.Rect
		System.out.println(this.getClass().getName()+"도형을 그려요");
	}
	public abstract double computeArea();	//추상메소드
}
