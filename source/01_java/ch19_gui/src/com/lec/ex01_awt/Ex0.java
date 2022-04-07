package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("자바 첫 GUI 예제");	//frame의 레이아웃 타입 : BorderLayout
		Button btn = new Button("버튼");
		frame.add(btn, BorderLayout.NORTH);	//버튼을 NORTH쪽에 추가
		Button btn1 = new Button("그냥 버튼");
		frame.add(btn1, BorderLayout.CENTER);	//그냥버튼을 CENTER에 추가
		frame.setSize(new Dimension(300, 200));
		frame.setVisible(true);
		frame.setLocation(100, 50);
		//3초 후 자동 창닫고 실행 종료
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false);
		frame.dispose(); // 자원해제
		System.exit(0); // 강제종료

	}
}
