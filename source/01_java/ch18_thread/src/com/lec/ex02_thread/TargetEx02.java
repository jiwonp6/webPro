package com.lec.ex02_thread;
//TargetEx02 t2 = new TargetEx02();
public class TargetEx02 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.print(Thread.currentThread().getName());
			System.out.println((i+1)+"번째 반갑습니다.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
