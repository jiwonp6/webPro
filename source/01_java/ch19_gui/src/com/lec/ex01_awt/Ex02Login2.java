package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02Login2 extends Frame {
	private Panel panel;
	private Label lbl1;
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;

	public Ex02Login2(String title) { // Frame에 컴포넌트 추가하고 화면 보이게 -> 이벤트
		super(title); // 맨 첫번째줄
		// Frame의 레이아웃 기본타입 : BorderLayout(동, 서, 남, 북, CENTER) 기본값
		// 						 FlowLayout(왼쪽부터 오른쪽으로, 위부터 아래로 차곡차곡 컴포넌트 add)
		// 						 GridLayout(몇 행 몇 열)
		// 						 setLayout(new FlowLayout()); //Frame의 레이아웃 세팅 //보조 레이아웃(panel) 사용해서 필요X
		panel = new Panel(); // 패널의 기본 레이아웃 : FlowLayout
		// panel = new Panel(new GridLayout(2, 2));
		// =>panel = new Panel();
		// setLayout(new GridLayout(2, 2));
		lbl1  = new Label("아 이 디");
		txtId = new TextField("ID",20);	//눈에 보이는 길이가 글자수 20정도
		lbl2  = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("LOGIN");
		
		panel.add(lbl1);
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		panel.setPreferredSize(new Dimension(280, 50));
		
		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		add(btnLogin);
		setSize(new Dimension(300, 150)); // 창의 크기 설정
		setLocation(200, 100); // 창의 위치설정
		setVisible(true);
		setResizable(false); // 사용자가 사이즈 조정 불가
		// x 클릭 시 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // true하면 보이고 false하면 안보임(종료)
				dispose(); // 자원 해제
				System.exit(0); // 강제종료
			}
		});
	}
	public Ex02Login2() {
		this(""); // 빈 title
	}
//main
	public static void main(String[] args) {
		new Ex02Login2("Login");
	}
}
