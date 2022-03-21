package com.lec.ex4_boxOrRect;
//직육면체의 가로, 세로, 높이, 부피를 속성으로 갖는 클래스를 구현하라. 
//부피를 구하는 메소드 getVolume()도 구현한다.
//출력하는 메소드 vPrint()도 구현한다.
public class BoxOrRect {
	private int width;
	private int length;
	private int height;
	private int volume;
	
//Rect
	public BoxOrRect() {}
	public BoxOrRect(int width, int length) {	//rect일 경우
		this.width = width;
		this.length = length;
		volume = width*length;
	}
	public BoxOrRect(int width, int length, int height) {
		this.width = width;
		this.length = length;
		this.height = height;
		volume = width*length*height;
	}
//메소드
	public int getVolume() {
		return volume;
	}
	public void vPrint() {
		if(height>0) {	//box
			System.out.printf("부피는 %d\n", volume);
		}else {		//height = 1; <--- 앞에서 초기화 해줌
			System.out.printf("넓이는 %d", volume);
		}	
	}	
//setter&getter
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
