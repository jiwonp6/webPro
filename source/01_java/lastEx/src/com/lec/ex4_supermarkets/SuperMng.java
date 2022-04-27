package com.lec.ex4_supermarkets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class SuperMng extends JFrame implements ActionListener {
	// DAO
	private CustomerDao dao = CustomerDao.getInstance(); // �̱���
	// ȭ�鱸��
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount;
	private Vector<String> levelnames;
	private JComboBox<String> comLevelname;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOuput, btnAllOutput, btnInsert, btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	// ������
	public SuperMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������Ʈ ��ü ����
		container = getContentPane(); // �����̳ʴ� �⺻�� BorderLayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3)); // �г��� �⺻�� FlowLayout
		jpbtn = new JPanel();
		txtCid = new JTextField(20);
		txtCtel = new JTextField(20);
		txtCname = new JTextField(20);
		txtCpoint = new JTextField(20);
		txtCamount = new JTextField(20);
		levelnames = dao.getLevelNames();
		comLevelname = new JComboBox<String>(levelnames);
		btnCidSearch = new JButton("���̵�˻�");
		btnCtelSearch = new JButton("��ȭ��ȣ�˻�");
		btnCnameSearch = new JButton("�̸��˻�");
		btnBuyWithPoint = new JButton("����Ʈ�α���");
		btnBuy = new JButton("���Ǳ���");
		btnLevelNameOuput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCtelUpdate = new JButton("��ȭ��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");
		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		// �����̳ʿ� ������Ʈ ��ġ
		jpup.add(new JLabel("�� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("�� ��ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("�� �̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5�� 3���� �� �� �߰�
		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelname);
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOuput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setVisible(true);
		setSize(new Dimension(800, 400));
		setLocation(200, 100);
		txtPool.setText("\t�� �� �� �� �˻� �� �����ϼ��� �� �� ��");
		// �̺�Ʈ �߰�
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOuput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCtelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCidSearch) {
			txtCtel.setText(""); // �⺻ �ƹ��͵� ���°ɷ� ����
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedIndex(0);
			int cid;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� id�� �Է��Ͻ� �� �˻��ϼ���");
				return;
			} // try-catch
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if (customer != null) {
				// txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				txtCamount.setText(""); // ��ǰ���ž� ��������
				// txtCamount.setText(String.valueOf(customer.getCamount()));
				comLevelname.setSelectedItem(customer.getLevelname());
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				txtPool.append(customer.toString());
			} else {
				txtPool.setText("�˻����� ���� id�Դϴ�");
			}
		} else if (e.getSource() == btnCtelSearch) {
			txtCid.setText(""); // �⺻ �ƹ��͵� ���°ɷ� ����
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedIndex(0);
			String ctel = txtCtel.getText().trim();
			if (ctel.length() < 4) {
				txtPool.setText("��� ��4�ڸ� �̻��� �Է��ϼž� �˻��˴ϴ�.");
				return;
			}
			ArrayList<CustomerDto> customer = dao.cTelGetCustomer(ctel);
			if (customer.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					txtCid.setText(String.valueOf(c.getCid()));
					txtCname.setText(c.getCname());
					txtCtel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCamount.setText(""); // ��ǰ���ž� ��������
					//txtCamount.setText(String.valueOf(c.getCamount()));
					comLevelname.setSelectedItem(c.getLevelname());
					txtPool.append(c.toString()+"\n");
				}
			} else {
				txtPool.setText("��ȿ���� ���� ��ȭ��ȣ�Դϴ�");
			}
		} else if (e.getSource() == btnCnameSearch) {
			txtCid.setText(""); // �⺻ �ƹ��͵� ���°ɷ� ����
			txtCtel.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedIndex(0);
			String cname = txtCname.getText().trim();
			
			ArrayList<CustomerDto> customer = dao.cNameGetCustomer(cname);
			if (customer.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					txtCid.setText(String.valueOf(c.getCid()));
					txtCname.setText(c.getCname());
					txtCtel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCamount.setText(""); // ��ǰ���ž� ��������
					//txtCamount.setText(String.valueOf(c.getCamount()));
					comLevelname.setSelectedItem(c.getLevelname());
					txtPool.append(c.toString()+"\n");
				}
			} else {
				if (cname.length() == 0) {
				txtPool.setText("ȸ���� �̸��� �Է����ּ���");
				}else {
				txtPool.setText("�ش� �̸��� ȸ���� �������� �ʽ��ϴ�");
				}
			}
		} else if (e.getSource() == btnBuyWithPoint) {
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
				if(cpoint<camount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ ���Ű� �Ұ��մϴ�");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��id�� point�� ���űݾ��� �Է��Ͻ� �� �����ϼ���");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("����Ʈ���ż���");
				txtCpoint.setText(String.valueOf(cpoint-camount));	//������ ����Ʈ�� ����
				txtCamount.setText("");
			}else {
				txtPool.setText("��id�� ��ȿ���� �ʽ��ϴ�. �� �˻� �� ������ �ּ���");
			}
		} else if (e.getSource() == btnBuy) {
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��id�� point�� ���űݾ��� �Է��Ͻ� �� �����ϼ���");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("���ż���");
				txtCpoint.setText(String.valueOf(cpoint + (int)(camount*0.05)));	//������ ����Ʈ�� ����
				txtCamount.setText("");
			}else {
				txtPool.setText("��id�� ��ȿ���� �ʽ��ϴ�. �� �˻� �� ������ �ּ���");
			}
		} else if (e.getSource() == btnLevelNameOuput) {
			txtCid.setText(""); // �⺻ �ƹ��͵� ���°ɷ� ����
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			String levelname = comLevelname.getSelectedItem().toString();
			ArrayList<CustomerDto> customer = dao.levelNameGetCustomer(levelname);
			if (customer.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					comLevelname.setSelectedItem(c.getLevelname());
					txtPool.append(c.toString()+"\n");
				}
				txtPool.append("=> �� "+customer.size()+"��");
			} else {
				if (levelname.length() == 0) {
				txtPool.setText("���ϴ� ����� �����Ͻð� �˻��ϼ���");
				}else {
				txtPool.setText("�ش� ����� ȸ���� �������� �ʽ��ϴ�");
				}
			}
		} else if (e.getSource() == btnAllOutput) {
			txtCid.setText(""); // �⺻ �ƹ��͵� ���°ɷ� ����
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedItem("");
			ArrayList<CustomerDto> customer = dao.getCustomers();
			if (customer.size() != 0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					txtPool.append(c.toString()+"\n");
				}
			} else {
				txtPool.setText("��ϵ� ȸ���� �����ϴ�.");
			}
		} else if (e.getSource() == btnInsert) {
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelname.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			if((ctel.length()<8&&ctel.indexOf('-')!=-1)||cname.length()<1) {
				txtPool.setText("��ȭ��ȣ�� �̸��� Ȯ�����ּ���");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ���޵Ǿ����ϴ�");
				txtCtel.setText("");
			}else {
				txtPool.setText("ȸ�����Խ���");
			}
		} else if (e.getSource() == btnCtelUpdate) {
			txtCid.setText(""); // �⺻ �ƹ��͵� ���°ɷ� ����
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			String cidStr = txtCid.getText().trim();
			int cid = Integer.parseInt(cidStr);
			String ctel = txtCtel.getText().trim();
			if(ctel.length()<8) {
				txtPool.setText("������ ��ȭ��ȣ�� Ȯ�����ּ���");
				return;
			}
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ȭ��ȣ ���� ����");
				txtCtel.setText("");
			}else {
				txtPool.setText("��ȭ��ȣ ���� ����");
			}
		} else if (e.getSource() == btnDelete) {
			txtCid.setText(""); // �⺻ �ƹ��͵� ���°ɷ� ����
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			String ctel = txtCtel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż�� �������ּ���");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("ȸ��Ż�𼺰�");
				txtCtel.setText("");
			}else {
				txtPool.setText("��ġ�ϴ� ��ȭ��ȣ�� �����ϴ�");
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
		new SuperMng("���۸��� ����");
	}
}
