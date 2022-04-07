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
		// 버튼 2개를 추가한 프레임
		btn = new Button("버튼");
		btn1 = new Button("그냥 버튼");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);

		pack(); // 최소한의 사이즈로
		setSize(new Dimension(300, 200));
		setVisible(true);
		setLocation(100, 50);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		setVisible(false);
		dispose(); // 자원해제
		System.exit(0); // 강제종료
	}
	public static void main(String[] args) {
		new Ex01_MyFrame("first GUI");
	}
}
