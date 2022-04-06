package com.lec.ex04_threadNObjectN;

public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target1 = new TargetEx();
		TargetEx target2 = new TargetEx();
		Thread threadA = new Thread(target1, "A");	//thread는 2개지만 target은 1개라 B도 num이 같이 올라감
		Thread threadB = new Thread(target2, "B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (Exception e) {}
		System.out.println("target1의 num:"+target1.getNum());
		System.out.println("target2의 num:"+target2.getNum());
		System.out.println("main 함수 끝");
	}
}
