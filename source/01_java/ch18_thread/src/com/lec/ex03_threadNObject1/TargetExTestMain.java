package com.lec.ex03_threadNObject1;

public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target = new TargetEx();
		Thread threadA = new Thread(target, "A");	//thread�� 2������ target�� 1���� B�� num�� ���� �ö�
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		System.out.println("main �Լ� ��");
	}
}
