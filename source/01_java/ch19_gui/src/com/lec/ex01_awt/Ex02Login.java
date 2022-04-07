package com.lec.ex01_awt;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex02Login extends Frame{
	private Label     lbl1;
	private TextField txtId;
	private Label     lbl2;
	private TextField txtPw;
	private Button    btnLogin;
	public Ex02Login(String title) { // Frame에 컴포넌트 추가하고 화면 보이게 -> 이벤트
		super(title);
		// Frame의 레이아웃 타입 : BorderLayout (동, 서, 남, 북, CENTER) 기본값
		//                    FlowLayout (왼쪽부터 오른쪽으로, 위부터 아래로 차곡차곡 컴포넌트 add)
		//                    GridLayout (몇행몇열)
		setLayout(new FlowLayout()); // Frame의 레이아웃 셋팅
		lbl1  = new Label("아 이 디");
		txtId = new TextField("ID",20);
		lbl2  = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("LOGIN");
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300, 150));
		setLocation(200,100);
		setVisible(true);
		setResizable(false); // 사용자가 size 조정 불가
		// x 클릭시 종료 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 안보이게
				dispose();         // 자원 해제
				System.exit(0);    // 강제 종료
			}
		});
	}
	public Ex02Login() {
		this("");
	}
	public static void main(String[] args) {
		new Ex02Login("Login");
	}
}