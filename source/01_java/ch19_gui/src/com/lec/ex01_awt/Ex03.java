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

// layout����, ������Ʈ ���� �� add, setVisible, setSize
	public Ex03() {
		// Frame �⺻ ���̾ƿ��� Borderlayout�̶� ���� setLayout�� �ʿ� ����
		panel = new Panel();
		// panel = new Panel(new FlowLayout()); //panel �⺻ ���̾ƿ��̶� ����
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();

		panel.add(new Label("wirte"));
		panel.add(txtField); // �̺�Ʈ�� �ʿ��� ���� new�� ���� �ʰ� ���� private���� ���� ��������
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true); // ���� ���̰�
		setSize(new Dimension(400, 150)); // ũ�⼳��
		setLocation(200, 50); // ��ġ ����
// x Ŭ�� �� ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // true�ϸ� ���̰� false�ϸ� �Ⱥ���(����)
				dispose(); // �ڿ� ����
				System.exit(0); // ��������
			}
		});
//�̺�Ʈ �߰�    1.implements ActionListener -> override
//			2.�̺�Ʈ ������ �߰� (V) �߿�!!!
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);	//this�� override�� �Լ�ȣ��
//			3.�����߰�(override�� �Լ� �ȿ�)		

	}
	public Ex03(String title) {
		this();
		setTitle(title);
	}
//override
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == (btnOk)) {	//Ok��ư Ŭ���� �� ���� : txtField�� �ؽ�Ʈ�� list �߰�
						//equals�ᵵ ��� ����	
			list.add(txtField.getText().trim().toUpperCase());
			txtField.setText("");
			
		}else if(e.getSource() == btnExit) {	//�������
			setVisible(false); // �Ⱥ��̰�
			dispose(); // �ڿ� ����
			System.exit(0); // ��������
		}
	}

//main
	public static void main(String[] args) {
		new Ex03("Ÿ��Ʋ�̶��");
	}
}
