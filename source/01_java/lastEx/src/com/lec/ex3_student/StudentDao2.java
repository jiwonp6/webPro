package com.lec.ex3_student;

import com.lec.ex2_person_dtoDao.PersonDao;

public class StudentDao2 {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static StudentDao2 INSTANCE;	//싱글톤으로 만들기위해
	public static int SUCCESS = 1;	//가독성 높이기위함
	public static int FAIL = 0;
	//생성자함수
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
	//1번. 학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		
		return 0;
		
	}
	
	//2번. 학생수정
	
	//3번. 학생출력
	
	//4번. 제적자출력
	
	//5번. 제적처리
	
	//6번. 종료
	
	
	
	
	
	
}
