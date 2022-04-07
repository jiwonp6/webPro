package com.lec.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true);  // 매개변수 안에 true 넣어줘야함 프로그램이 끝나도 계속 timer가 상주 끝나면 종료시켜주는 의미
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1 , 2000); // 2초후에 task1 수행
		timer.schedule(task2, 1000,500); // 1초후 0.5초마다 task2.run()을 수행
 		// 5초동안 잠깐 끝내지말고 멈춤
		Thread.sleep(5000);
		
		System.out.println("끝");
	}

}
