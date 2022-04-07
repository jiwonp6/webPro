package com.lec.ex02_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01_Thursday extends JFrame implements ActionListener{
	private JPanel panel;	//받아온 컨테이너를 저장
	//private Container contenPane;	//받아온 컨테이너를 저장
	private JButton jbtn;
	private JLabel jlbl;
	
	public Ex01_Thursday(String title) {	//컨테이너 받아와서 컴포넌트 add
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//X버튼 클릭시 종료
		//스윙은 컨테이너 얻어오기(맨처음)
		panel = (JPanel) getContentPane();	//형변환, 외곽의 큰프레임을 얻어와서 형 변환시켜주는 것
		panel.setLayout(new FlowLayout());
		jbtn = new JButton("EXIT");
		jlbl = new JLabel("안녕 친구들", (int)CENTER_ALIGNMENT);	//패널위에 아무거나 다 올릴 수 있음, 라벨생성 시에 int로 형변환하고 위치가운데 정렬
		
		panel.add(jlbl);
		jlbl.setPreferredSize(new Dimension(150, 200));
		panel.add(jbtn);
		jbtn.setPreferredSize(new Dimension(200, 200));
		setVisible(true);
		setSize(new Dimension(400, 250));
		setLocation(200, 50);
		//이벤트 리스너 추가
		jbtn.addActionListener(this);
	}
//override	
	@Override
	public void actionPerformed(ActionEvent e) {	//이벤트 로직
		if(e.getSource() == jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);		//정상종료
		}
	}
//Main	
	public static void main(String[] args) {
		new Ex01_Thursday("타이틀이라고라고라");
	}
}
