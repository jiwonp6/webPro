package com.lec.ex03_threadNObject1;

public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target = new TargetEx();
		Thread threadA = new Thread(target, "A");	//thread는 2개지만 target은 1개라 B도 num이 같이 올라감
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
	}
}
