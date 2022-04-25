package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
			// -> PersonDao dao = new PersonDao();	//private�̶� new ��ü ���� �Ұ���
		PersonDto dto = new PersonDto("����", "���", 60, 80, 70);

		//1. �Է� test
		System.out.println("---1�� �׽�Ʈ---");
		int result = dao.insertPerson(dto);	
		System.out.println(result == PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
		
		//2. ������ ��ȸ test
		System.out.println("---2�� �׽�Ʈ---");
		ArrayList<PersonDto> dtos = dao.selectJname("���");	
		if(dtos.size()>0) {	//������� ������ ���� �Ǻ� or dtos.isEmpty()
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("�ش������� ����� ��ϵ��� �ʾҽ��ϴ�.");
		}

		//3. ��ü��ȸ test
		System.out.println("---3�� �׽�Ʈ---");
		dtos = dao.selectAll();
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}//for
		}else {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}
		//4. ������ ����Ʈ test
		System.out.println("---4�� �׽�Ʈ---");
		Vector<String> jnames = dao.jnamelist();
		System.out.println(jnames);
	}
}
