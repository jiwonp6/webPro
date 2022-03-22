package com.lec.quiz01;
//(번호)lec1   (ID)G01	(이름):이길동	(부서)객체지향
public class Gangsa extends Person{
	private String buseo;
	private static int count;
	public Gangsa(String id, String name, String buseo) {
		super(id, name);
		this.buseo = buseo;
		int gangsaNum = 1;
		gangsaNum = ++count;
		System.out.print("(번호)lec"+gangsaNum+"\t(ID)"+id+"\t(이름)"+name+"\t(부서)"+buseo);
		System.out.println();
	}
	
	
	
}
