package com.lec.ex02_swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.*;

public class Ex02 extends JFrame implements ActionListener {
	// private static final String EXIT_ON_CLOSE = null;
	// �ʿ��� ������Ʈ ���� �߰�
	private JPanel jpanel; // �����̳� ���� ����
	private Container contenPane;
	private ImageIcon icon; // ��ư�� �� icon
	private JButton jBtn;
	private JTextField jTxtField;
	private Vector<String> items; // �ĺ��ڽ��� �� item����Ʈ(item�� �������϶��� Vector, �������� ���� String�迭�� ó��)
	private String[] item = { "A", "B", "C" };
	private JComboBox<String> jCombo;
	private JCheckBox jCheck;
	private JLabel jlBlank; // �� ��
	private JButton jBtnExit; // �����ư

	// ������ : �����̳� ���ͼ� layout ���� -> ������Ʈ ���� �� add - setVisible, setSize(ȭ�鱸��) -> �̺�Ʈ
	// �߰�
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // xŬ���� ����
		contenPane = getContentPane(); // swing�� �����̳ʸ� ���� �� �۾�
		// jpanel = (JPanel)getContentPane();
		contenPane.setLayout(new FlowLayout()); // ���̾ƿ� ����
		icon = new ImageIcon("icon/write.gif");
		jBtn = new JButton("Button", icon);
		jTxtField = new JTextField(20);
		// jCombo = new JComboBox<String>(item); //�ĺ��ڽ� item����Ʈ �߰� ��� 1. string �迭(����)
		items = new Vector<String>();
		// items �߰��� ���׵� ��������
		items.add("A");
		items.add("B");
		items.add("C");
		jCombo = new JComboBox<String>(items); // �ĺ��ڽ� item����Ʈ �߰� ���2. vector �̿�(������)
		jCheck = new JCheckBox("CheckBox");
		jlBlank = new JLabel("");
		jBtnExit = new JButton("EXIT");

		// ������Ʈ add -> ������Ʈ ������ ����(pdf����)
		contenPane.add(new JLabel("Label"));
		contenPane.add(jBtn);
		contenPane.add(jTxtField);
		contenPane.add(jCombo);
		contenPane.add(jCheck);
		contenPane.add(jlBlank);
		contenPane.add(jBtnExit);
		jBtn.setPreferredSize(new Dimension(200, 50));
		jTxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jCheck.setPreferredSize(new Dimension(100, 50));
		jlBlank.setPreferredSize(new Dimension(200, 50));
		jBtnExit.setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		pack(); // ������Ʈ���� ������ �ּ����� ������� ����
		setLocation(100, 50);
		// �̺�Ʈ ������ �߰�
		jBtn.addActionListener(this);
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jBtnExit.addActionListener(this);

	}

//override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jBtn) {
			String temp = jTxtField.getText().trim().toUpperCase();
			if (temp.equals("")) {
				System.out.println("�߸��Է��ϼ̽��ϴ�"); // jTxtField�� ��Ʈ���̰ų� space�� �Է����� ���
				return;
			}
			jCombo.addItem(temp); // �޺��ڽ��� item �߰�( = items���Ϳ� �߰�)
			jlBlank.setText(jTxtField.getText().trim()); // jlBlank���� jTxtField �Է� ���� �״��
			jTxtField.setText("");
		} else if (e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString();
			int no = jCombo.getSelectedIndex();
			jlBlank.setText((no+1) + "��°" + temp + "����");
			jCombo.setSelectedItem("A"); // "A"�� ���õǵ��� jCombo.setSelectedIndex(0);

		} else if (e.getSource() == jCheck) {
			if (jCheck.isSelected()) { // üũ�ڽ� üũ��
				jlBlank.setText(jCheck.getText());

			} else { // üũ�ڽ� ��üũ��
				jlBlank.setText("");
			}
		} else if (e.getSource() == jBtnExit) {
			setVisible(false); 
			dispose(); 
			System.exit(0); 
		}
	}

//main
	public static void main(String[] args) {
		new Ex02();// ����
	}

}
