package com.lec.ex07_timer;

import java.util.TimerTask;

public  class TimerTaskEx1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("작업 1 : 2초후에 한번 수행될 예정인 작업(TimerTask) @@@");		
	}
	

}
