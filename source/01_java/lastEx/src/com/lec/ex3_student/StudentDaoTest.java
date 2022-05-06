package com.lec.ex3_student;

import java.util.ArrayList;
import java.util.Vector;



public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		StudentDto dto = new StudentDto("홍길동", "유기소재공학", 50);
		//0.
		System.out.println("---0번 테스트---");
		Vector<String> mnames = dao.getMnamelist();
		System.out.println(mnames);
		//1.
		System.out.println("---1번 테스트---");
		dto = dao.sNogetStudent(2022001);
		if(dto != null) {
			System.out.println(dto);
		}else {
			System.out.println("해당학번의 학생이 존재하지 않습니다.");
		}
		//2.
		System.out.println("---2번 테스트---");
		ArrayList<StudentDto> dtos = dao.selectSname("박지원");	
		if(dtos.size()>0) {	
			for(StudentDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("해당 학생 없음");
		}
		//3.
		System.out.println("---3번 테스트---");
		ArrayList<StudentDto> dtos1 = dao.selectMname("유기소재공학");	
		if(dtos1.size()>0) {	
			for(StudentDto d : dtos1) {
				System.out.println(d);
			}
		}else {
			System.out.println("6.해당 학과 없음");
		}
		//4.
		System.out.println("---4번 테스트---");
		int result = dao.insertStudent(dto);	
		System.out.println(result != StudentDao.FAIL ? "입력성공" : "입력실패");
		//5.
		System.out.println("---5번 테스트---");
		int result2 = dao.updateStudent(dto);	
		System.out.println(result2 != StudentDao.FAIL ? "입력성공" : "입력실패");
		//6.
		System.out.println("---6번 테스트---");
		ArrayList<StudentDto> dtos2 = dao.selectAll();		
		for(StudentDto d : dtos2) {
			System.out.println(d);
		}
		//7.
		System.out.println("---7번 테스트---");
		ArrayList<StudentDto> dtos3 = dao.selectsexpel();		
		for(StudentDto d : dtos3) {
			System.out.println(d);
		}
		//8.
		System.out.println("---8번 테스트---");
		int result3 = dao.expelupdateStudent(dto.getSno());	
		System.out.println(result3 != StudentDao.FAIL ? "입력성공" : "입력실패");
		
	}
}
