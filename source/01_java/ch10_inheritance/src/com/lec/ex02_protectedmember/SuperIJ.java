package com.lec.ex02_protectedmember;
//순서) 데이터 - 생성자 - 메소드 - 오버라이드 메소드(재세팅) - setter&getter
public class SuperIJ {
	private int i;
	private int j;
	//상속받은 클래스에서 Super 클래스(부모단) 매개변수 없는 생성자 함수를 먼저 호출
	public SuperIJ() {
		System.out.println("매개변수 없는거 SuperIJ 생성자 함수");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 SuperIJ 생성자 함수로 i, j값 초기화");
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getI() {
		return i;
	}
	public void setJ(int j) {
		this.j = j;
	}
	protected int getJ() {
		return j;
	}
}
