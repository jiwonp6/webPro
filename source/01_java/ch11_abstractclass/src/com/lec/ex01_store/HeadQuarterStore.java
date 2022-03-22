package com.lec.ex01_store;

public abstract class HeadQuarterStore {	//abstract <- 추상 클래스로 정의
	//본사
	private String str;	
	public HeadQuarterStore(String str) {
		//super();	//object로 부터 상속받은 디폴트생성자
		this.str = str;
	}
	//메소드 구현은 없이 선언만 돼있는 메소드 : 추상메소드(상속받은 클래스에서 오버라이드) <- 객체 생성 불가능
		// -> 클래스 내 추상 메소드가 하나 이상일 때 : 추상클래스
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gonggibab();
	//getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
