package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	//Poitn p = new Point(1, 2);
	//p.pointPrint();
	//System.out.println(p.infoString());
	//System.out.println(p);
	public Point() {}
	public void pointPrint() {	//�����ε�(�Լ� �ߺ�����)
		System.out.println("2���� ��ǥ : x="+x+"\ty="+y);
	}
	public String infoString() {
		return "2���� ��ǥ : x="+x+"\ty="+y;
	}
	@Override	//�������̵�(toString �Լ� ������)	= ��ӹ��� �Լ��� �Ű�����, ����Ÿ�� ����
	public String toString() {
		return "2���� ��ǥ : x="+x+"\ty="+y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
