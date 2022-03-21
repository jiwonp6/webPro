//패키지명, 클래스명, 데이터, 생성자함수(오버로딩), 메소드, setter & getter

//매개변수 있는 생성자 만들면
//		매개변수 없는 디폴트 생성자 항상 하나 만들어 놔야함
package com.lec.ex1_square;

public class Square {
	private int side;
	//생성자함수 자체가 없을 때는 JVM이 디폴트생성자(아무것도 하지 않고 매개변수 없는 생성자)를 만듦
											//->private int side;
	//생성자함수 : return type이 없는, class명과 같은 함수, 데이터 초기화
	public Square() {	//매개변수 없는 생성자 함수
		System.out.println("매개변수 없는 생성자 함수 호출됨");
		
	}
	public Square(int side) {	//매개변수 있는 생성자 함수 용도 
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출됨. side 초기화");
	}
	public int area() {
		return side*side;
	}
//	setter & getter
	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
