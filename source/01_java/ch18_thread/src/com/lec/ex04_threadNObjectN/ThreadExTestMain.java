package com.lec.ex04_threadNObjectN;

public class ThreadExTestMain {
	public static void main(String[] args) {
		ThreadEx threadA = new ThreadEx("A");
		ThreadEx threadB = new ThreadEx("B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {	}
		System.out.println("targetAÀÇ num:"+threadA.getNum());
		System.out.println("targetBÀÇ num:"+threadB.getNum());
	}
}
