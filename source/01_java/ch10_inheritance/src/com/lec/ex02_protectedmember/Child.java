package com.lec.ex02_protectedmember;

public class Child extends SuperIJ{	//상속을 SuperIJ에서 받으므로 뒤에 extends SuperIJ써줌
	private int total;

	public Child() {
		System.out.println("매개변수 없는 Child 생성자");
	}
	//생성자
		// Child c = new Child(10, 20);
	public Child(int i, int j) {	//super클래스에서 상속받은 i, j 초기화
		setI(i);
		setJ(j);
		System.out.println("매개변수 있는 Child 생성자");
	}
	//메소드
	public void sum() {	//void ---> return타입X
		total = getI() + getJ();	// total = i+j;
		System.out.printf("본 객체의 i=%d, j=%d\n", getI(), getJ());
		System.out.printf("본 객체의 total=%d", total);
	}



}
