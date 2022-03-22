package com.lec.ex03_shape;

public class Triangle extends Shape {
	private int w;	//πÿ∫Ø
	private int h;	//≥Ù¿Ã
	
	public Triangle() {}
	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public double computeArea() {
		return w*h*0.5;
	}
}
