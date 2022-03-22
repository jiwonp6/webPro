package com.lec.quiz01;
//(번호)st101  (ID)A01	(이름):강유미	(반)JAVA반
//(번호)st102  (ID)A02	(이름):홍길동	(반)C++반
//(번호)staff1  (ID)S01	(이름):유길동	(과목)운영지원팀
//(번호)staff2  (ID)S01	(이름):김길동	(과목)취업지원팀
//(번호)lec1   (ID)G01	(이름):이길동	(부서)객체지향
public class TestMain {
	public static void main(String[] args) {
		Person p[] = {new Student("A01", "강유미", "Java반"),
				new Student("A02", "홍길동", "C++반"),
				new Staff("S01", "유길동", "운영지원팀"),
				new Staff("S02", "김길동", "취업지원팀"), 
				new Gangsa("G01", "이길동", "객체지향")};
	}
}
