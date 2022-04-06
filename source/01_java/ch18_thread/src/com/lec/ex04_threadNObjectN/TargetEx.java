package com.lec.ex04_threadNObjectN;

public class TargetEx implements Runnable{
	private int num = 0;
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			if(Thread.currentThread().getName().equals("A")) {	//"A"쓰레드일 경우
				System.out.println("~~~A 쓰레드 수행중~~~");
				num++;
			}
			System.out.println(Thread.currentThread().getName()+"의 num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public int getNum() {
		return num;
	}
}
