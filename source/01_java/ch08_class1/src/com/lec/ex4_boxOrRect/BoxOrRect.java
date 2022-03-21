package com.lec.ex4_boxOrRect;
//������ü�� ����, ����, ����, ���Ǹ� �Ӽ����� ���� Ŭ������ �����϶�. 
//���Ǹ� ���ϴ� �޼ҵ� getVolume()�� �����Ѵ�.
//����ϴ� �޼ҵ� vPrint()�� �����Ѵ�.
public class BoxOrRect {
	private int width;
	private int length;
	private int height;
	private int volume;
	
//Rect
	public BoxOrRect() {}
	public BoxOrRect(int width, int length) {	//rect�� ���
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
//�޼ҵ�
	public int getVolume() {
		return volume;
	}
	public void vPrint() {
		if(height>0) {	//box
			System.out.printf("���Ǵ� %d\n", volume);
		}else {		//height = 1; <--- �տ��� �ʱ�ȭ ����
			System.out.printf("���̴� %d", volume);
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
