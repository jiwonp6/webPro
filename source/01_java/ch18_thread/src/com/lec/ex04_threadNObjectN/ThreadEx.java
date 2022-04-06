package com.lec.ex04_threadNObjectN;
//ThreadEx threadA = new ThreadEx("A")
//threadA.setName("A")
public class ThreadEx extends Thread{
	private int num = 0;
	public ThreadEx(String name) {
		super(name);
	}
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
