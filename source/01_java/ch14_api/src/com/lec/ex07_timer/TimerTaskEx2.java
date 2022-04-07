package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {

	@Override
	public void run() {
		System.out.println("작업2 : 1초후에 0.5초 마다 계속 수행될 예정인 작업(TimerTask) ★★★");
	}
	

}
