package com.lec.ex0_warmup;
//이름, 국, 영, 수, 총점, 평균
public class Warmup {
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int tot=kor+mat+eng;
	private double avg=tot/3.0;
	
	
	public Warmup() {}
	public Warmup(String name, int kor, int mat, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
		tot=kor+mat+eng;
		avg=tot/3.0;
	}	
//메소드
	public int setTot() {
		return tot;
	}
	public double setAvg() {
		return avg;
	}
	public void vPrint() {
		System.out.printf("%s \t"
				+ "%d\t%d\t%d\t%d\t%.1f\n", name, kor, mat, kor, tot, avg);
	}	
	public int totKor() {
		return kor;
	}
	public int totMat() {
		return mat;
	}
	public int totEng() {
		return eng;
	}
	
//setter&getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}

}
