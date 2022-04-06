package com.lec.ex03_threadNObject1;

public class TargetEx implements Runnable{
	private int num = 0;
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	
	}
	private synchronized void out() {	//순서 바꾸지 않고 수행하기위해 싱크로나이즈드 함수로
		if(Thread.currentThread().getName().equals("A")) {	//"A"쓰레드일 경우
				System.out.println("~~~A 쓰레드 수행중~~~");
				num++;
		}
		System.out.println(Thread.currentThread().getName()+"의 num = " + num);
	}
}
