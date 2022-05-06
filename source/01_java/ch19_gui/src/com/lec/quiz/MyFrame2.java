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
	private Container contenPane; // 컨테이너 얻어올 변수
	private JPanel jp1; // 이름, 전화, 나이 받을 6개 컴포넌트를 girdLayout으로 add
	private JPanel jp2;
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon iconIn, iconOut;
	private JButton btnIn, btnOut;
	private ArrayList<Person> person = new ArrayList<Person>();

//생성자
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
		btnOut = new JButton("출력", iconOut);
		btnIn = new JButton("입력", iconIn);

		jp1.add(new JLabel("이   름", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("전   화", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(new JLabel("나   이", (int) CENTER_ALIGNMENT));
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
				System.out.println("이름과 전화번호는 필수 입력 사항입니다");
				return;
			} 
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) {
				System.out.println("전화번호 형식을 확인해 주세요");
				return;
			}
			age = Integer.parseInt(txtAge.getText());
			if (age < 0 || age > 150) {
				System.out.println("유효하지 않은 나이입니다.");
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
