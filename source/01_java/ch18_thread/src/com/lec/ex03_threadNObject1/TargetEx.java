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
	private synchronized void out() {	//���� �ٲ��� �ʰ� �����ϱ����� ��ũ�γ������ �Լ���
		if(Thread.currentThread().getName().equals("A")) {	//"A"�������� ���
				System.out.println("~~~A ������ ������~~~");
				num++;
		}
		System.out.println(Thread.currentThread().getName()+"�� num = " + num);
	}
}
