package com.lec.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true);  // �Ű����� �ȿ� true �־������ ���α׷��� ������ ��� timer�� ���� ������ ��������ִ� �ǹ�
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1 , 2000); // 2���Ŀ� task1 ����
		timer.schedule(task2, 1000,500); // 1���� 0.5�ʸ��� task2.run()�� ����
 		// 5�ʵ��� ��� ���������� ����
		Thread.sleep(5000);
		
		System.out.println("��");
	}

}
