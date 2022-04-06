package com.lec.ex02_thread;
//Thread t1 = new ThreadEx01();
public class TargetEx01 extends Thread{
	public TargetEx01() {}
	public TargetEx01(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println("\n"+Thread.currentThread().getName());
		for(int i=0; i<10; i++) {
			System.out.println("¾È³çÇÏ¼¼¿ä - " + (i+1));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
