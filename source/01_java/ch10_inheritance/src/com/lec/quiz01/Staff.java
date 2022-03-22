package com.lec.quiz01;
//(번호)staff1  (ID)S01	(이름):유길동	(과목)운영지원팀
//(번호)staff2  (ID)S01	(이름):김길동	(과목)취업지원팀
public class Staff extends Person{
	private String guamok;
	private static int count;
	public Staff(String id, String name, String guamok) {
		super(id, name);
		this.guamok = guamok;
		int staffNum = 1;
		staffNum = ++count;
		System.out.print("(번호)staff"+staffNum+"\t(ID)"+id+"\t(이름)"+name+"\t(과목)"+guamok);
		System.out.println();
	}
	
}
