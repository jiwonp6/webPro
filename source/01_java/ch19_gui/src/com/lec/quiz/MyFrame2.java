package com.lec.quiz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame implements ActionListener {
	private Container contenPane; // �����̳� ���� ����
	private JPanel jp1; // �̸�, ��ȭ, ���� ���� 6�� ������Ʈ�� girdLayout���� add
	private JPanel jp2;
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon iconIn, iconOut;
	private JButton btnIn, btnOut;
	private ArrayList<Person> person = new ArrayList<Person>();

//������
	public MyFrame2(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp1 = new JPanel(new GridLayout(3, 2));
		jp2 = new JPanel(new FlowLayout(1, 2, 1));
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		iconOut = new ImageIcon("icon/output.png");
		iconIn = new ImageIcon("icon/join.png");
		btnOut = new JButton("���", iconOut);
		btnIn = new JButton("�Է�", iconIn);

		jp1.add(new JLabel("��   ��", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("��   ȭ", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(new JLabel("��   ��", (int) CENTER_ALIGNMENT));
		jp1.add(txtAge);

		jp2.add(btnIn, BorderLayout.WEST);
		jp2.add(btnOut, BorderLayout.EAST);

		contenPane.add(jp1, BorderLayout.NORTH);
		contenPane.add(jp2, BorderLayout.SOUTH);

		setVisible(true);
		setBounds(200, 100, 400, 200);

		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
	}
	OutputStream fos = null;
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = null;
		String tel = null;
		int age = 0;
		name = txtName.getText().trim();
		tel = txtTel.getText().trim();
		if (e.getSource() == btnIn) {
			try {
				age = Integer.parseInt(txtAge.getText());
			} catch (Exception e1) {
				age = -1;
			}
			if (name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� �����Դϴ�");
				return;
			} 
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) {
				System.out.println("��ȭ��ȣ ������ Ȯ���� �ּ���");
				return;
			}
			age = Integer.parseInt(txtAge.getText());
			if (age < 0 || age > 150) {
				System.out.println("��ȿ���� ���� �����Դϴ�.");
				age = 0;
			}
			person.add(new Person(name, tel, age));
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		} else if (e.getSource() == btnOut) {
			try {
				fos = new FileOutputStream("src/com/lec/quiz/person.txt");
				for(Person p : person) {
					System.out.println(p);
					fos.write((p.toString()+"\n").getBytes());
				}
			}catch (IOException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(fos!=null) fos.close();
				}catch (Exception e1) { }
			}
		}//else if	
	}// override
//main
	public static void main(String[] args) {
		new MyFrame2("Quiz");
	}

}
