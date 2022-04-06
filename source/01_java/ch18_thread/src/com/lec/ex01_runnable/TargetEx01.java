package com.lec.ex01_runnable;
//"안녕하세요" 10번 실행하는 target
public class TargetEx01 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("안녕하세요 - " + (i+1));
			try {
				Thread.sleep(500);	//너무 빨라서 동시에 하는 것처럼 보이게 하기위해 0.5초 대기상태로
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
