package com.lec.ex04_threadNObjectN;

public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target1 = new TargetEx();
		TargetEx target2 = new TargetEx();
		Thread threadA = new Thread(target1, "A");	//thread�� 2������ target�� 1���� B�� num�� ���� �ö�
		Thread threadB = new Thread(target2, "B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (Exception e) {}
		System.out.println("target1�� num:"+target1.getNum());
		System.out.println("target2�� num:"+target2.getNum());
		System.out.println("main �Լ� ��");
	}
}
