package com.lec.ex11_final;
//Animal로 부터 speed, running(), stop() 상속 받음
public class Dog extends Animal{
	@Override
	public void running() {
		//speed += 10; <--- 상속받았지만 final 이라 바꿀 수 없음 -> get, set이용!
		setSpeed(getSpeed()+10);	//speed += 10
		System.out.println("꼬리를 흔들며 뛰어요. 현재속도 : "+ getSpeed());
	}
}
