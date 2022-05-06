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
	// DB관련
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
		btnsNoSearch = new JButton("학번검색");
		btnsNameSearch = new JButton("이름검색");
		btnmNameSearch = new JButton("전공검색");
		btnsNoSearch.setPreferredSize(new Dimension(100, 50));
		btnsNameSearch.setPreferredSize(new Dimension(100, 50));
		btnmNameSearch.setPreferredSize(new Dimension(100, 50));

		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		btnInput.setPreferredSize(new Dimension(90, 30));
		btnUpdate.setPreferredSize(new Dimension(90, 30));
		btnStudentOut.setPreferredSize(new Dimension(90, 30));
		btnExpelOut.setPreferredSize(new Dimension(90, 30));
		btnExpel.setPreferredSize(new Dimension(90, 30));
		btnExit.setPreferredSize(new Dimension(90, 30));
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		// 생성된 컴포넌트 추가
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtsNo);
		jpup.add(btnsNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtsName);
		jpup.add(btnsNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(commName);
		jpup.add(btnmNameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
// 1번. 학번검색
		if (e.getSource() == btnsNoSearch) {
			String snoStr = txtsNo.getText().trim();
			if(snoStr.equals("")) {
				txtPool.setText("학번을 입력해주세요\n");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			StudentDto dto = dao.sNogetStudent(sno);
			if (dto != null) {
				txtsName.setText(dto.getSname());
				commName.setSelectedItem(dto.getMname());
				txtScore.setText(Integer.toString(dto.getScore()));
			} else {
				txtPool.setText("해당학번의 학생이 존재하지 않습니다.\n");
			}
// 2번. 이름검색
		} else if (e.getSource() == btnsNameSearch) {
			String sname = txtsName.getText().trim();
			ArrayList<StudentDto> dtos = dao.selectSname(sname);
			if (dtos.size() > 1) {
				txtPool.append("학번\t이름\t전공\t점수\n");
				for (StudentDto d : dtos) {
					txtPool.append(d.toString());
					txtPool.append("\n");
				}
			} else if (dtos.size() == 1) {
				txtsNo.setText(Integer.toString(dtos.get(0).getSno()));
				commName.setSelectedItem(dtos.get(0).getMname());
				txtScore.setText(Integer.toString(dtos.get(0).getScore()));
			} else {
				txtPool.setText("해당 학생 없음");
			}
// 3번. 전공검색			
		} else if (e.getSource() == btnmNameSearch) {
			String mname = commName.getSelectedItem().toString().trim();
			ArrayList<StudentDto> dtos1 = dao.selectMname(mname);
			if (mname.equals("")) {
				txtPool.setText("학과를 선택하셔야 가능\n");
				return;
			}
			if (dtos1.size() > 0) {
				txtPool.append("학번\t이름\t전공\t점수\n");
				for (StudentDto d : dtos1) {
					txtPool.append(d.toString());
					txtPool.append("\n");
				}
			} else {
				txtPool.append("해당 학과 학생 없음\n");
			}
// 4번. 학생입력			
		} else if (e.getSource() == btnInput) {
			String score = txtScore.getText().trim();
			String sname = txtsName.getText().trim();
			String mname = commName.getSelectedItem().toString().trim();
			if (score.equals("") || sname.equals("") || mname.equals("")) {
				txtPool.setText("이름, 학과, 점수를 입력하셔야 가능");
				return;
			}
			StudentDto newStudent = new StudentDto(sname, mname, Integer.parseInt(score));
			int result = dao.insertStudent(newStudent);
			if (result == StudentDao.SUCCESS) {
				txtPool.setText(sname + "님 입력성공");
				txtsName.setText("");
				commName.setSelectedIndex(0);
				txtScore.setText("");
			}
// 5번. 학생수정
		} else if (e.getSource() == btnUpdate) {
			String snoStr = txtsNo.getText().trim();
			if(snoStr.equals("")) {
				txtPool.setText("학번을 입력해주세요\n");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			String score = txtScore.getText().trim();
			String sname = txtsName.getText().trim();
			String mname = commName.getSelectedItem().toString().trim();
			if(snoStr.equals("")) {
				txtPool.setText("학번을 입력해주세요");
				return;
			}
			StudentDto newStudent = new StudentDto(sno, sname, mname, Integer.parseInt(score));
			int result = dao.updateStudent(newStudent);
			if (result == StudentDao.SUCCESS) {
				txtPool.setText(sname + "님 수정성공");
				txtsNo.setText("");
				txtsName.setText("");
				commName.setSelectedIndex(0);
				txtScore.setText("");
			}
// 6번. 학생 출력			
		} else if (e.getSource() == btnStudentOut) {
			ArrayList<StudentDto> student = dao.selectAll();
			txtPool.setText("등수\t이름\t\t전공\t\t점수\n");
			for(StudentDto dto : student) {
				txtPool.append(dto.toString());
			}
// 7번. 제적자 출력
		} else if (e.getSource() == btnExpelOut) {
			ArrayList<StudentDto> student = dao.selectsexpel();
			txtPool.setText("학번\t이름\t전공\t\t점수\n");
			for(StudentDto dto : student) {
				txtPool.append(dto.toString());
			}
// 8번. 제적처리			
		} else if (e.getSource() == btnExpel) {
			String snoStr = txtsNo.getText().trim();
			if(snoStr.equals("")) {
				txtPool.setText("학번을 입력해주세요\n");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			int result = dao.expelupdateStudent(sno);
			if (result == StudentDao.SUCCESS) {
				txtPool.setText("제적처리 성공");
				txtsNo.setText("");
				txtsName.setText("");
				commName.setSelectedIndex(0);
				txtScore.setText("");
			}else {
				txtPool.setText("해당학번의 학생이 존재하지 않습니다.\n");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		} else {
			txtPool.setText("실행할 작업이 없습니다.");
		}

	}
	public static void main(String[] args) {
		new StudentMngGUI("학생성적입력");
	}

}
