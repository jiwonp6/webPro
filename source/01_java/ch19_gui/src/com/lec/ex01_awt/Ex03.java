package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame implements ActionListener {
	private Panel panel;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List list;

// layout세팅, 컴포넌트 생성 후 add, setVisible, setSize
	public Ex03() {
		// Frame 기본 레이아웃이 Borderlayout이라 따로 setLayout할 필요 없음
		panel = new Panel();
		// panel = new Panel(new FlowLayout()); //panel 기본 레이아웃이라 생략
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();

		panel.add(new Label("wirte"));
		panel.add(txtField); // 이벤트에 필요한 것은 new로 쓰지 않고 라벨을 private으로 따로 빼놔야함
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true); // 눈에 보이게
		setSize(new Dimension(400, 150)); // 크기설정
		setLocation(200, 50); // 위치 설정
// x 클릭 시 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // true하면 보이고 false하면 안보임(종료)
				dispose(); // 자원 해제
				System.exit(0); // 강제종료
			}
		});
//이벤트 추가    1.implements ActionListener -> override
//			2.이벤트 리스너 추가 (V) 중요!!!
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);	//this는 override된 함수호출
//			3.로직추가(override된 함수 안에)		

	}
	public Ex03(String title) {
		this();
		setTitle(title);
	}
//override
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == (btnOk)) {	//Ok버튼 클릭시 할 로직 : txtField의 텍스트를 list 추가
						//equals써도 상관 없음	
			list.add(txtField.getText().trim().toUpperCase());
			txtField.setText("");
			
		}else if(e.getSource() == btnExit) {	//종료로직
			setVisible(false); // 안보이게
			dispose(); // 자원 해제
			System.exit(0); // 강제종료
		}
	}

//main
	public static void main(String[] args) {
		new Ex03("타이틀이라네");
	}
}
