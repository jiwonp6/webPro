package com.lec.quiz01;
//(��ȣ)lec1   (ID)G01	(�̸�):�̱浿	(�μ�)��ü����
public class Gangsa extends Person{
	private String buseo;
	private static int count;
	public Gangsa(String id, String name, String buseo) {
		super(id, name);
		this.buseo = buseo;
		int gangsaNum = 1;
		gangsaNum = ++count;
		System.out.print("(��ȣ)lec"+gangsaNum+"\t(ID)"+id+"\t(�̸�)"+name+"\t(�μ�)"+buseo);
		System.out.println();
	}
	
	
	
}
