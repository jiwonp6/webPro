package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex01_MyFrame extends Frame {
	private Button btn;
	private Button btn1;

	public Ex01_MyFrame(String title) {
		super(title);
		// ��ư 2���� �߰��� ������
		btn = new Button("��ư");
		btn1 = new Button("�׳� ��ư");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);

		pack(); // �ּ����� �������
		setSize(new Dimension(300, 200));
		setVisible(true);
		setLocation(100, 50);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		setVisible(false);
		dispose(); // �ڿ�����
		System.exit(0); // ��������
	}
	public static void main(String[] args) {
		new Ex01_MyFrame("first GUI");
	}
}
