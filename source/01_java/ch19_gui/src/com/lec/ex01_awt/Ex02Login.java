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
	public Ex02Login(String title) { // Frame�� ������Ʈ �߰��ϰ� ȭ�� ���̰� -> �̺�Ʈ
		super(title);
		// Frame�� ���̾ƿ� Ÿ�� : BorderLayout (��, ��, ��, ��, CENTER) �⺻��
		//                    FlowLayout (���ʺ��� ����������, ������ �Ʒ��� �������� ������Ʈ add)
		//                    GridLayout (����)
		setLayout(new FlowLayout()); // Frame�� ���̾ƿ� ����
		lbl1  = new Label("�� �� ��");
		txtId = new TextField("ID",20);
		lbl2  = new Label("��й�ȣ");
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
		setResizable(false); // ����ڰ� size ���� �Ұ�
		// x Ŭ���� ���� 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // �Ⱥ��̰�
				dispose();         // �ڿ� ����
				System.exit(0);    // ���� ����
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