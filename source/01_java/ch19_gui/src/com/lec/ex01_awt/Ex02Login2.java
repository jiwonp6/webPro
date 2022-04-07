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

	public Ex02Login2(String title) { // Frame�� ������Ʈ �߰��ϰ� ȭ�� ���̰� -> �̺�Ʈ
		super(title); // �� ù��°��
		// Frame�� ���̾ƿ� �⺻Ÿ�� : BorderLayout(��, ��, ��, ��, CENTER) �⺻��
		// 						 FlowLayout(���ʺ��� ����������, ������ �Ʒ��� �������� ������Ʈ add)
		// 						 GridLayout(�� �� �� ��)
		// 						 setLayout(new FlowLayout()); //Frame�� ���̾ƿ� ���� //���� ���̾ƿ�(panel) ����ؼ� �ʿ�X
		panel = new Panel(); // �г��� �⺻ ���̾ƿ� : FlowLayout
		// panel = new Panel(new GridLayout(2, 2));
		// =>panel = new Panel();
		// setLayout(new GridLayout(2, 2));
		lbl1  = new Label("�� �� ��");
		txtId = new TextField("ID",20);	//���� ���̴� ���̰� ���ڼ� 20����
		lbl2  = new Label("��й�ȣ");
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
		setSize(new Dimension(300, 150)); // â�� ũ�� ����
		setLocation(200, 100); // â�� ��ġ����
		setVisible(true);
		setResizable(false); // ����ڰ� ������ ���� �Ұ�
		// x Ŭ�� �� ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // true�ϸ� ���̰� false�ϸ� �Ⱥ���(����)
				dispose(); // �ڿ� ����
				System.exit(0); // ��������
			}
		});
	}
	public Ex02Login2() {
		this(""); // �� title
	}
//main
	public static void main(String[] args) {
		new Ex02Login2("Login");
	}
}
