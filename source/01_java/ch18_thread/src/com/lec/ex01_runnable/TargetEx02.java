package com.lec.ex01_runnable;
//"반갑습니다" 10번 실행하는 target
public class TargetEx02 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println((i+1)+"번째 반갑습니다.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
