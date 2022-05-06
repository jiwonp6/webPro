package com.lec.quiz3;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Customer extends JFrame implements ActionListener {
	private CustomerDao dao = CustomerDao.getInstance();
	private Container container;
	private JPanel jpup, jpdown;
	private JTextField txtCphone, txtCname, txtCpoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	public Customer(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane(); // �����̳ʴ� �⺻�� BorderLayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2)); // �г��� �⺻�� FlowLayout
		jpdown = new JPanel();
		txtCphone = new JTextField(15);
		txtCname = new JTextField(15);
		txtCpoint = new JTextField(15);
		btnJoin = new JButton("����");
		btnSearch = new JButton("����ȸ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");
		txtPool = new JTextArea(15, 30);
		scrollPane = new JScrollPane(txtPool);

		jpup.add(new JLabel("����ȣ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCphone);
		jpup.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		container.add(jpup);
		container.add(jpdown);
		container.add(scrollPane);
		setVisible(true);
		setSize(new Dimension(400, 480));
		setLocation(200, 100);
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) {
			try {
				String cphone = txtCphone.getText().trim();
				String cname = txtCname.getText().trim();
				String cpointStr = txtCpoint.getText().trim();
				int cpoint = Integer.parseInt(cpointStr);
				if ((cphone.length() < 8 && cphone.indexOf('-') != -1) || cname.length() < 1) {
					txtPool.setText("��ȭ��ȣ�� �̸��� Ȯ�����ּ���");
					txtCphone.setText("");
					txtCname.setText("");
					txtCpoint.setText("");
					return;
				}
				int result = dao.insertCustomer(cphone, cname, cpoint);
				if (result == CustomerDao.SUCCESS) {
					txtPool.setText("�����մϴ�. ����Ʈ 1000���� ���޵Ǿ����ϴ�");
					txtCphone.setText("");
					txtCname.setText("");
					txtCpoint.setText("");
				} else {
					txtPool.setText("����");
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��ȭ��ȣ�� �̸�, ����Ʈ�� �Է����ּ���");
				return;
			}
		} else if (e.getSource() == btnSearch) {
			String cphone = txtCphone.getText().trim();
			if (cphone.length() < 4) {
				txtPool.setText("��� ��4�ڸ� �̻��� �Է��ϼž� �˻��˴ϴ�.");
				txtCname.setText("");
				txtCpoint.setText("");
				return;
			}
			ArrayList<CustomerDto> customer = dao.cphoneGetCustomer(cphone);
			if (customer.size() != 0) {
				txtPool.setText("�̸�\t��ȭ��ȣ\t\t����Ʈ\n");
				txtPool.append("---------------------------------------------------------------------------\n");
				for (CustomerDto c : customer) {
					txtCname.setText(c.getCname());
					txtCphone.setText(c.getCphone());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtPool.append(c.toString() + "\n");
				}
			} else {
				txtCname.setText("");
				txtCpoint.setText("");
				txtPool.setText("��ȿ���� ���� ��ȭ��ȣ�Դϴ�.");
			}
		} else if (e.getSource() == btnOutput) {
			txtCphone.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			ArrayList<CustomerDto> customer = dao.getCustomers();
			if (customer.size() != 0) { // ���
				txtPool.setText("�̸�\t��ȭ��ȣ\t\t����Ʈ\n");
				txtPool.append("---------------------------------------------------------------------------\n");
				for (CustomerDto c : customer) {
					txtPool.append(c.toString() + "\n");
				}
			} else {
				txtPool.setText("��ϵ� ȸ���� �����ϴ�.");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		} else {
			txtPool.setText("����");
		}
	}

	public static void main(String[] args) {
		new Customer("ȸ������");
	}
}
