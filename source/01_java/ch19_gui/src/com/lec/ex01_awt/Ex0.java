package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("�ڹ� ù GUI ����");	//frame�� ���̾ƿ� Ÿ�� : BorderLayout
		Button btn = new Button("��ư");
		frame.add(btn, BorderLayout.NORTH);	//��ư�� NORTH�ʿ� �߰�
		Button btn1 = new Button("�׳� ��ư");
		frame.add(btn1, BorderLayout.CENTER);	//�׳ɹ�ư�� CENTER�� �߰�
		frame.setSize(new Dimension(300, 200));
		frame.setVisible(true);
		frame.setLocation(100, 50);
		//3�� �� �ڵ� â�ݰ� ���� ����
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false);
		frame.dispose(); // �ڿ�����
		System.exit(0); // ��������

	}
}
