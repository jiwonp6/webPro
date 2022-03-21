package com.lec.ex0_warmup;

public class WarmupTest {
	public static void main(String[] args) {
	Warmup a = new Warmup("정우성", 90, 90, 90);
	Warmup b = new Warmup("김하늘", 90, 91, 90);
	Warmup c = new Warmup("황정민", 80, 80, 80);
	Warmup d = new Warmup("강동원", 80, 81, 80);
	Warmup e = new Warmup("유아인", 70, 70, 70);
	
	
	//printLine();
	System.out.println("\t\t\t성적표");
	
	a.vPrint();
	b.vPrint();
	c.vPrint();
	d.vPrint();
	e.vPrint();
	int kortot =a.totKor()+b.totKor()+c.totKor()+d.totKor()+e.totKor();
	System.out.println("국어 총점:"+kortot);
	int mattot =a.totMat()+b.totMat()+c.totMat()+d.totMat()+e.totMat();
	System.out.println("수학 총점:"+mattot);
	int engtot =a.totEng()+b.totEng()+c.totEng()+d.totEng()+e.totEng();
	System.out.println("영어 총점:"+engtot);
	
	}
}