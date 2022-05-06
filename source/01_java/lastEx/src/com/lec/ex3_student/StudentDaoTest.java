package com.lec.ex3_student;

import java.util.ArrayList;
import java.util.Vector;



public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		StudentDto dto = new StudentDto("ȫ�浿", "����������", 50);
		//0.
		System.out.println("---0�� �׽�Ʈ---");
		Vector<String> mnames = dao.getMnamelist();
		System.out.println(mnames);
		//1.
		System.out.println("---1�� �׽�Ʈ---");
		dto = dao.sNogetStudent(2022001);
		if(dto != null) {
			System.out.println(dto);
		}else {
			System.out.println("�ش��й��� �л��� �������� �ʽ��ϴ�.");
		}
		//2.
		System.out.println("---2�� �׽�Ʈ---");
		ArrayList<StudentDto> dtos = dao.selectSname("������");	
		if(dtos.size()>0) {	
			for(StudentDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("�ش� �л� ����");
		}
		//3.
		System.out.println("---3�� �׽�Ʈ---");
		ArrayList<StudentDto> dtos1 = dao.selectMname("����������");	
		if(dtos1.size()>0) {	
			for(StudentDto d : dtos1) {
				System.out.println(d);
			}
		}else {
			System.out.println("6.�ش� �а� ����");
		}
		//4.
		System.out.println("---4�� �׽�Ʈ---");
		int result = dao.insertStudent(dto);	
		System.out.println(result != StudentDao.FAIL ? "�Է¼���" : "�Է½���");
		//5.
		System.out.println("---5�� �׽�Ʈ---");
		int result2 = dao.updateStudent(dto);	
		System.out.println(result2 != StudentDao.FAIL ? "�Է¼���" : "�Է½���");
		//6.
		System.out.println("---6�� �׽�Ʈ---");
		ArrayList<StudentDto> dtos2 = dao.selectAll();		
		for(StudentDto d : dtos2) {
			System.out.println(d);
		}
		//7.
		System.out.println("---7�� �׽�Ʈ---");
		ArrayList<StudentDto> dtos3 = dao.selectsexpel();		
		for(StudentDto d : dtos3) {
			System.out.println(d);
		}
		//8.
		System.out.println("---8�� �׽�Ʈ---");
		int result3 = dao.expelupdateStudent(dto.getSno());	
		System.out.println(result3 != StudentDao.FAIL ? "�Է¼���" : "�Է½���");
		
	}
}
