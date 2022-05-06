package com.lec.ex3_student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import com.lec.ex2_person_dtoDao.PersonDao;
import com.lec.ex2_person_dtoDao.PersonDto;
import com.lec.ex2_person_dtoDao.PersonMngGUI;

public class StudentMngGUI extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtsNo, txtsName, txtScore;
	private JComboBox<String> commName;
	private Vector<String> mname;
	private JButton btnsNoSearch, btnsNameSearch, btnmNameSearch;
	private JButton btnInput, btnUpdate, btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	// DB����
	private StudentDao dao = StudentDao.getInstance();
	private ArrayList<StudentDto> person;

	public StudentMngGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel();
		txtsNo = new JTextField(10);
		mname = dao.getMnamelist();
		commName = new JComboBox<String>(mname);
		txtsName = new JTextField(10);
		txtScore = new JTextField(10);
		btnsNoSearch = new JButton("�й��˻�");
		btnsNameSearch = new JButton("�̸��˻�");
		btnmNameSearch = new JButton("�����˻�");
		btnsNoSearch.setPreferredSize(new Dimension(100, 50));
		btnsNameSearch.setPreferredSize(new Dimension(100, 50));
		btnmNameSearch.setPreferredSize(new Dimension(100, 50));

		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		btnInput.setPreferredSize(new Dimension(90, 30));
		btnUpdate.setPreferredSize(new Dimension(90, 30));
		btnStudentOut.setPreferredSize(new Dimension(90, 30));
		btnExpelOut.setPreferredSize(new Dimension(90, 30));
		btnExpel.setPreferredSize(new Dimension(90, 30));
		btnExit.setPreferredSize(new Dimension(90, 30));
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		// ������ ������Ʈ �߰�
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtsNo);
		jpup.add(btnsNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtsName);
		jpup.add(btnsNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(commName);
		jpup.add(btnmNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);

		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);

		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);

		btnsNoSearch.addActionListener(this);
		btnsNameSearch.addActionListener(this);
		btnmNameSearch.addActionListener(this);

		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
// 1��. �й��˻�
		if (e.getSource() == btnsNoSearch) {
			String snoStr = txtsNo.getText().trim();
			if(snoStr.equals("")) {
				txtPool.setText("�й��� �Է����ּ���\n");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			StudentDto dto = dao.sNogetStudent(sno);
			if (dto != null) {
				txtsName.setText(dto.getSname());
				commName.setSelectedItem(dto.getMname());
				txtScore.setText(Integer.toString(dto.getScore()));
			} else {
				txtPool.setText("�ش��й��� �л��� �������� �ʽ��ϴ�.\n");
			}
// 2��. �̸��˻�
		} else if (e.getSource() == btnsNameSearch) {
			String sname = txtsName.getText().trim();
			ArrayList<StudentDto> dtos = dao.selectSname(sname);
			if (dtos.size() > 1) {
				txtPool.append("�й�\t�̸�\t����\t����\n");
				for (StudentDto d : dtos) {
					txtPool.append(d.toString());
					txtPool.append("\n");
				}
			} else if (dtos.size() == 1) {
				txtsNo.setText(Integer.toString(dtos.get(0).getSno()));
				commName.setSelectedItem(dtos.get(0).getMname());
				txtScore.setText(Integer.toString(dtos.get(0).getScore()));
			} else {
				txtPool.setText("�ش� �л� ����");
			}
// 3��. �����˻�			
		} else if (e.getSource() == btnmNameSearch) {
			String mname = commName.getSelectedItem().toString().trim();
			ArrayList<StudentDto> dtos1 = dao.selectMname(mname);
			if (mname.equals("")) {
				txtPool.setText("�а��� �����ϼž� ����\n");
				return;
			}
			if (dtos1.size() > 0) {
				txtPool.append("�й�\t�̸�\t����\t����\n");
				for (StudentDto d : dtos1) {
					txtPool.append(d.toString());
					txtPool.append("\n");
				}
			} else {
				txtPool.append("�ش� �а� �л� ����\n");
			}
// 4��. �л��Է�			
		} else if (e.getSource() == btnInput) {
			String score = txtScore.getText().trim();
			String sname = txtsName.getText().trim();
			String mname = commName.getSelectedItem().toString().trim();
			if (score.equals("") || sname.equals("") || mname.equals("")) {
				txtPool.setText("�̸�, �а�, ������ �Է��ϼž� ����");
				return;
			}
			StudentDto newStudent = new StudentDto(sname, mname, Integer.parseInt(score));
			int result = dao.insertStudent(newStudent);
			if (result == StudentDao.SUCCESS) {
				txtPool.setText(sname + "�� �Է¼���");
				txtsName.setText("");
				commName.setSelectedIndex(0);
				txtScore.setText("");
			}
// 5��. �л�����
		} else if (e.getSource() == btnUpdate) {
			String snoStr = txtsNo.getText().trim();
			if(snoStr.equals("")) {
				txtPool.setText("�й��� �Է����ּ���\n");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			String score = txtScore.getText().trim();
			String sname = txtsName.getText().trim();
			String mname = commName.getSelectedItem().toString().trim();
			if(snoStr.equals("")) {
				txtPool.setText("�й��� �Է����ּ���");
				return;
			}
			StudentDto newStudent = new StudentDto(sno, sname, mname, Integer.parseInt(score));
			int result = dao.updateStudent(newStudent);
			if (result == StudentDao.SUCCESS) {
				txtPool.setText(sname + "�� ��������");
				txtsNo.setText("");
				txtsName.setText("");
				commName.setSelectedIndex(0);
				txtScore.setText("");
			}
// 6��. �л� ���			
		} else if (e.getSource() == btnStudentOut) {
			ArrayList<StudentDto> student = dao.selectAll();
			txtPool.setText("���\t�̸�\t\t����\t\t����\n");
			for(StudentDto dto : student) {
				txtPool.append(dto.toString());
			}
// 7��. ������ ���
		} else if (e.getSource() == btnExpelOut) {
			ArrayList<StudentDto> student = dao.selectsexpel();
			txtPool.setText("�й�\t�̸�\t����\t\t����\n");
			for(StudentDto dto : student) {
				txtPool.append(dto.toString());
			}
// 8��. ����ó��			
		} else if (e.getSource() == btnExpel) {
			String snoStr = txtsNo.getText().trim();
			if(snoStr.equals("")) {
				txtPool.setText("�й��� �Է����ּ���\n");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			int result = dao.expelupdateStudent(sno);
			if (result == StudentDao.SUCCESS) {
				txtPool.setText("����ó�� ����");
				txtsNo.setText("");
				txtsName.setText("");
				commName.setSelectedIndex(0);
				txtScore.setText("");
			}else {
				txtPool.setText("�ش��й��� �л��� �������� �ʽ��ϴ�.\n");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		} else {
			txtPool.setText("������ �۾��� �����ϴ�.");
		}

	}
	public static void main(String[] args) {
		new StudentMngGUI("�л������Է�");
	}

}
