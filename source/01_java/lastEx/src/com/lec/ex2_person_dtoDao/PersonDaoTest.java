package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
			// -> PersonDao dao = new PersonDao();	//private이라 new 객체 생성 불가능
		PersonDto dto = new PersonDto("김길순", "배우", 60, 80, 70);

		//1. 입력 test
		System.out.println("---1번 테스트---");
		int result = dao.insertPerson(dto);	
		System.out.println(result == PersonDao.SUCCESS ? "입력성공" : "입력실패");
		
		//2. 직업별 조회 test
		System.out.println("---2번 테스트---");
		ArrayList<PersonDto> dtos = dao.selectJname("배우");	
		if(dtos.size()>0) {	//사이즈로 데이터 유무 판별 or dtos.isEmpty()
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("해당직업의 사람이 등록되지 않았습니다.");
		}

		//3. 전체조회 test
		System.out.println("---3번 테스트---");
		dtos = dao.selectAll();
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}//for
		}else {
			System.out.println("등록된 사람이 없습니다.");
		}
		//4. 직업명 리스트 test
		System.out.println("---4번 테스트---");
		Vector<String> jnames = dao.jnamelist();
		System.out.println(jnames);
	}
}
