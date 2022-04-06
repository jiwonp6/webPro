package com.lec.ex01_runnable;

public class TargetExMain {
	public static void main(String[] args) {
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02();
		Thread threadA = new Thread(target1, "A");	//"A"라는 이름의 쓰레드 생성
		Thread threadB = new Thread(target2, "B");	//"B"라는 이름의 쓰레드 생성
		threadA.start();	//쓰레드 실행시작
		threadB.start();
		for(int i=0; i<10; i++) {
			System.out.println("*나는 "+Thread.currentThread().getName()+(i+1));
			//Thread.currentThread().getName() : 현재 쓰레드 이름
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
