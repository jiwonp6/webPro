package com.lec.ex11_final;

public class Animal {
	private int speed;
	public void running() {
		speed += 5;
		System.out.println("�ٰ� �־��. ���� �ӵ� : " + speed);
	}
	public final void stop() {	//override ���� �޼ҵ�
		speed=0;
		System.out.println("����");
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
