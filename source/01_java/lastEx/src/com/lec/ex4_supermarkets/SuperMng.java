package com.lec.ex4_supermarkets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class SuperMng extends JFrame implements ActionListener {
	// DAO
	private CustomerDao dao = CustomerDao.getInstance(); // 싱글톤
	// 화면구현
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount;
	private Vector<String> levelnames;
	private JComboBox<String> comLevelname;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOuput, btnAllOutput, btnInsert, btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	// 생성자
	public SuperMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 컴포넌트 객체 생성
		container = getContentPane(); // 컨테이너는 기본이 BorderLayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3)); // 패널은 기본이 FlowLayout
		jpbtn = new JPanel();
		txtCid = new JTextField(20);
		txtCtel = new JTextField(20);
		txtCname = new JTextField(20);
		txtCpoint = new JTextField(20);
		txtCamount = new JTextField(20);
		levelnames = dao.getLevelNames();
		comLevelname = new JComboBox<String>(levelnames);
		btnCidSearch = new JButton("아이디검색");
		btnCtelSearch = new JButton("전화번호검색");
		btnCnameSearch = new JButton("이름검색");
		btnBuyWithPoint = new JButton("포인트로구매");
		btnBuy = new JButton("물건구매");
		btnLevelNameOuput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCtelUpdate = new JButton("전화번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");
		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		// 컨테이너에 컴포넌트 배치
		jpup.add(new JLabel("아 이 디", (int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("고객 전화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("고객 이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구매금액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5행 3열엔 빈 라벨 추가
		jpup.add(new JLabel("고객등급", (int) CENTER_ALIGNMENT));
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
		txtPool.setText("\t★ ★ ★ 고객 검색 후 구매하세요 ★ ★ ★");
		// 이벤트 추가
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
			txtCtel.setText(""); // 기본 아무것도 없는걸로 설정
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedIndex(0);
			int cid;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("유효한 고객 id를 입력하신 후 검색하세요");
				return;
			} // try-catch
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if (customer != null) {
				// txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				txtCamount.setText(""); // 물품구매액 넣을예정
				// txtCamount.setText(String.valueOf(customer.getCamount()));
				comLevelname.setSelectedItem(customer.getLevelname());
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				txtPool.append(customer.toString());
			} else {
				txtPool.setText("검색되지 않은 id입니다");
			}
		} else if (e.getSource() == btnCtelSearch) {
			txtCid.setText(""); // 기본 아무것도 없는걸로 설정
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedIndex(0);
			String ctel = txtCtel.getText().trim();
			if (ctel.length() < 4) {
				txtPool.setText("적어도 폰4자리 이상은 입력하셔야 검색됩니다.");
				return;
			}
			ArrayList<CustomerDto> customer = dao.cTelGetCustomer(ctel);
			if (customer.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					txtCid.setText(String.valueOf(c.getCid()));
					txtCname.setText(c.getCname());
					txtCtel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCamount.setText(""); // 물품구매액 넣을예정
					//txtCamount.setText(String.valueOf(c.getCamount()));
					comLevelname.setSelectedItem(c.getLevelname());
					txtPool.append(c.toString()+"\n");
				}
			} else {
				txtPool.setText("유효하지 않은 전화번호입니다");
			}
		} else if (e.getSource() == btnCnameSearch) {
			txtCid.setText(""); // 기본 아무것도 없는걸로 설정
			txtCtel.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedIndex(0);
			String cname = txtCname.getText().trim();
			
			ArrayList<CustomerDto> customer = dao.cNameGetCustomer(cname);
			if (customer.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					txtCid.setText(String.valueOf(c.getCid()));
					txtCname.setText(c.getCname());
					txtCtel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCamount.setText(""); // 물품구매액 넣을예정
					//txtCamount.setText(String.valueOf(c.getCamount()));
					comLevelname.setSelectedItem(c.getLevelname());
					txtPool.append(c.toString()+"\n");
				}
			} else {
				if (cname.length() == 0) {
				txtPool.setText("회원의 이름을 입력해주세요");
				}else {
				txtPool.setText("해당 이름의 회원이 존재하지 않습니다");
				}
			}
		} else if (e.getSource() == btnBuyWithPoint) {
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
				if(cpoint<camount) {
					txtPool.setText("포인트가 부족하여 포인트 구매가 불가합니다");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객id와 point와 구매금액을 입력하신 후 구매하세요");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("포인트구매성공");
				txtCpoint.setText(String.valueOf(cpoint-camount));	//차감된 포인트로 수정
				txtCamount.setText("");
			}else {
				txtPool.setText("고객id가 유효하지 않습니다. 고객 검색 후 구매해 주세요");
			}
		} else if (e.getSource() == btnBuy) {
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("유효한 고객id와 point와 구매금액을 입력하신 후 구매하세요");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("구매성공");
				txtCpoint.setText(String.valueOf(cpoint + (int)(camount*0.05)));	//차감된 포인트로 수정
				txtCamount.setText("");
			}else {
				txtPool.setText("고객id가 유효하지 않습니다. 고객 검색 후 구매해 주세요");
			}
		} else if (e.getSource() == btnLevelNameOuput) {
			txtCid.setText(""); // 기본 아무것도 없는걸로 설정
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			String levelname = comLevelname.getSelectedItem().toString();
			ArrayList<CustomerDto> customer = dao.levelNameGetCustomer(levelname);
			if (customer.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					comLevelname.setSelectedItem(c.getLevelname());
					txtPool.append(c.toString()+"\n");
				}
				txtPool.append("=> 총 "+customer.size()+"명");
			} else {
				if (levelname.length() == 0) {
				txtPool.setText("원하는 등급을 선택하시고 검색하세요");
				}else {
				txtPool.setText("해당 등급의 회원이 존재하지 않습니다");
				}
			}
		} else if (e.getSource() == btnAllOutput) {
			txtCid.setText(""); // 기본 아무것도 없는걸로 설정
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelname.setSelectedItem("");
			ArrayList<CustomerDto> customer = dao.getCustomers();
			if (customer.size() != 0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("---\t---\t---\t---\t---\t---\t---\t---\t---\n");
				for (CustomerDto c : customer) {
					txtPool.append(c.toString()+"\n");
				}
			} else {
				txtPool.setText("등록된 회원이 없습니다.");
			}
		} else if (e.getSource() == btnInsert) {
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelname.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			if((ctel.length()<8&&ctel.indexOf('-')!=-1)||cname.length()<1) {
				txtPool.setText("전화번호와 이름을 확인해주세요");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("회원가입 감사합니다. 포인트 1000점이 지급되었습니다");
				txtCtel.setText("");
			}else {
				txtPool.setText("회원가입실패");
			}
		} else if (e.getSource() == btnCtelUpdate) {
			txtCid.setText(""); // 기본 아무것도 없는걸로 설정
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			String cidStr = txtCid.getText().trim();
			int cid = Integer.parseInt(cidStr);
			String ctel = txtCtel.getText().trim();
			if(ctel.length()<8) {
				txtPool.setText("변경할 전화번호를 확인해주세요");
				return;
			}
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("전화번호 수정 성공");
				txtCtel.setText("");
			}else {
				txtPool.setText("전화번호 수정 실패");
			}
		} else if (e.getSource() == btnDelete) {
			txtCid.setText(""); // 기본 아무것도 없는걸로 설정
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			String ctel = txtCtel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("전화번호를 입력 후 회원탈퇴를 진행해주세요");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("회원탈퇴성공");
				txtCtel.setText("");
			}else {
				txtPool.setText("일치하는 전화번호가 없습니다");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		} else {
			txtPool.setText("오류");
		}
	}
	public static void main(String[] args) {
		new SuperMng("슈퍼마켓 관리");
	}
}
