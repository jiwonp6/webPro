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
	public void pointPrint() {	//오버로딩(함수 중복정의)
		System.out.println("2차원 좌표 : x="+x+"\ty="+y);
	}
	public String infoString() {
		return "2차원 좌표 : x="+x+"\ty="+y;
	}
	@Override	//오버라이드(toString 함수 재정의)	= 상속받은 함수의 매개변수, 리턴타입 동일
	public String toString() {
		return "2차원 좌표 : x="+x+"\ty="+y;
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
