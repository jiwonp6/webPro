package com.lec.ex11_final;
//Animal로 부터 speed, running(), stop() 상속 받음
public final class Rabbit extends Animal{
	@Override
	public void running() {
		setSpeed(getSpeed()+30);//speed += 30;
		System.out.println("깡충깡충 뛰어요. 현재속도 : " + getSpeed());
	}
}
