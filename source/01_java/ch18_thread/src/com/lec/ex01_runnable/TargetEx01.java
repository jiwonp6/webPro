package com.lec.ex01_runnable;
//"�ȳ��ϼ���" 10�� �����ϴ� target
public class TargetEx01 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("�ȳ��ϼ��� - " + (i+1));
			try {
				Thread.sleep(500);	//�ʹ� ���� ���ÿ� �ϴ� ��ó�� ���̰� �ϱ����� 0.5�� �����·�
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
