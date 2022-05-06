<<<<<<< HEAD
package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dtos;
		do {
			System.out.println("1:입력 || 2:직업별조회 || 3:전체조회 || 그외 : 종료");
			fn = sc.next();
			switch(fn) {
			case "1" : //이름, 직업명, 국, 영, 수 입력
				System.out.println("입력할 이름 ?");
				String pname = sc.next();
				System.out.println("직업(배우|가수)은?");
				String jname = sc.next();
				System.out.println("국어점수는?");
				int kor = sc.nextInt();
				System.out.println("영어점수는?");
				int eng = sc.nextInt();
				System.out.println("수학점수는?");
				int mat = sc.nextInt();
				int result = dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				System.out.println(result ==PersonDao.SUCCESS ? "입력성공" : "입력실패");
				break;
			case "2" : 
				System.out.println("직업별 조회");
				System.out.println("조회할 직업 ?");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(dtos.isEmpty()) {
					System.out.println("해당직업의 사람이 없습니다.");
				}else {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}	//for
				}	//if
				break;
			case "3" : 
				System.out.println("전체조회");
				dtos = dao.selectAll();
				if(dtos.isEmpty()) {
					System.out.println("등록된 사람이 없습니다.");
				}else {
					System.out.println("rank\t이름\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}	//for
				}
				break;
			}//switch
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("bye");
	}
}
=======
package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dtos;
		do {
			System.out.println("1:입력 || 2:직업별조회 || 3:전체조회 || 그외 : 종료");
			fn = sc.next();
			switch(fn) {
			case "1" : //이름, 직업명, 국, 영, 수 입력
				System.out.println("입력할 이름 ?");
				String pname = sc.next();
				System.out.println("직업(배우|가수)은?");
				String jname = sc.next();
				System.out.println("국어점수는?");
				int kor = sc.nextInt();
				System.out.println("영어점수는?");
				int eng = sc.nextInt();
				System.out.println("수학점수는?");
				int mat = sc.nextInt();
				int result = dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				System.out.println(result ==PersonDao.SUCCESS ? "입력성공" : "입력실패");
				break;
			case "2" : 
				System.out.println("직업별 조회");
				System.out.println("조회할 직업 ?");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(dtos.isEmpty()) {
					System.out.println("해당직업의 사람이 없습니다.");
				}else {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}	//for
				}	//if
				break;
			case "3" : 
				System.out.println("전체조회");
				dtos = dao.selectAll();
				if(dtos.isEmpty()) {
					System.out.println("등록된 사람이 없습니다.");
				}else {
					System.out.println("rank\t이름\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}	//for
				}
				break;
			}//switch
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("bye");
	}
}
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
