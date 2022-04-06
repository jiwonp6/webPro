package com.lec.ex01_runnable;

public class TargetExMain {
	public static void main(String[] args) {
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02();
		Thread threadA = new Thread(target1, "A");	//"A"��� �̸��� ������ ����
		Thread threadB = new Thread(target2, "B");	//"B"��� �̸��� ������ ����
		threadA.start();	//������ �������
		threadB.start();
		for(int i=0; i<10; i++) {
			System.out.println("*���� "+Thread.currentThread().getName()+(i+1));
			//Thread.currentThread().getName() : ���� ������ �̸�
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
