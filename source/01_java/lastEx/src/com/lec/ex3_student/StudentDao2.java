package com.lec.ex3_student;

import com.lec.ex2_person_dtoDao.PersonDao;

public class StudentDao2 {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static StudentDao2 INSTANCE;	//�̱������� ���������
	public static int SUCCESS = 1;	//������ ���̱�����
	public static int FAIL = 0;
	//�������Լ�
	public StudentDao2 StudentDao() {
		if(INSTANCE == null) {
			INSTANCE = new StudentDao2();
		}
		return INSTANCE;
	}
	private StudentDao2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//1��. �л��Է�
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		
		return 0;
		
	}
	
	//2��. �л�����
	
	//3��. �л����
	
	//4��. ���������
	
	//5��. ����ó��
	
	//6��. ����
	
	
	
	
	
	
}
