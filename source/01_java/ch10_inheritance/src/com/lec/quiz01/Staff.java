package com.lec.quiz01;
//(��ȣ)staff1  (ID)S01	(�̸�):���浿	(����)�������
//(��ȣ)staff2  (ID)S01	(�̸�):��浿	(����)���������
public class Staff extends Person{
	private String guamok;
	private static int count;
	public Staff(String id, String name, String guamok) {
		super(id, name);
		this.guamok = guamok;
		int staffNum = 1;
		staffNum = ++count;
		System.out.print("(��ȣ)staff"+staffNum+"\t(ID)"+id+"\t(�̸�)"+name+"\t(����)"+guamok);
		System.out.println();
	}
	
}
