package com.lec.ex03_shape;
//Shape�� ���� Rectangle(w,h), Traiangle(w,h), Circle(r)�� �� ������ ��
public abstract class Shape {
	public void draw() {
		String className = this.getClass().getName();	// com.lec.es03_shape.Circle
														// com.lec.ex03_shape.Rect
		System.out.println(this.getClass().getName()+"������ �׷���");
	}
	public abstract double computeArea();	//�߻�޼ҵ�
}
