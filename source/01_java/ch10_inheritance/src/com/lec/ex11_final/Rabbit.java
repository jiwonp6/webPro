package com.lec.ex11_final;
//Animal�� ���� speed, running(), stop() ��� ����
public final class Rabbit extends Animal{
	@Override
	public void running() {
		setSpeed(getSpeed()+30);//speed += 30;
		System.out.println("������� �پ��. ����ӵ� : " + getSpeed());
	}
}
