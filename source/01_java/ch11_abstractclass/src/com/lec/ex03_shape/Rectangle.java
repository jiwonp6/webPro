package com.lec.ex03_shape;

public class Rectangle extends Shape {
	private int w;	//가로길이
	private int h;	//세로길이
	
	public Rectangle() {}
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public double computeArea() {
		return w*h;
	}
}
