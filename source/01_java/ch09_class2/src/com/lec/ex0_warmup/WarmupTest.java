package com.lec.ex0_warmup;

public class WarmupTest {
	public static void main(String[] args) {
	Warmup a = new Warmup("���켺", 90, 90, 90);
	Warmup b = new Warmup("���ϴ�", 90, 91, 90);
	Warmup c = new Warmup("Ȳ����", 80, 80, 80);
	Warmup d = new Warmup("������", 80, 81, 80);
	Warmup e = new Warmup("������", 70, 70, 70);
	
	
	//printLine();
	System.out.println("\t\t\t����ǥ");
	
	a.vPrint();
	b.vPrint();
	c.vPrint();
	d.vPrint();
	e.vPrint();
	int kortot =a.totKor()+b.totKor()+c.totKor()+d.totKor()+e.totKor();
	System.out.println("���� ����:"+kortot);
	int mattot =a.totMat()+b.totMat()+c.totMat()+d.totMat()+e.totMat();
	System.out.println("���� ����:"+mattot);
	int engtot =a.totEng()+b.totEng()+c.totEng()+d.totEng()+e.totEng();
	System.out.println("���� ����:"+engtot);
	
	}
}