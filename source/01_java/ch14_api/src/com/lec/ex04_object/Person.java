package com.lec.ex04_object;
// 9512121025252

public class Person {
	private long juminNo;
	
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public String toString() {
		return "Person [juminNo=" + juminNo + "]";
	}
	@Override
	public boolean equals(Object obj) { 
		// p1.equals(p2) 호출할 경우 p1 대신 this, p2대신 obj => 내 객체의 juminNo 와 obj.juminNo가 같은지 여부를 return
		// p1.equals(p3) 호출할 경우 p3 대신 obj => false를 return
		if(obj != null && obj instanceof Person) { // 참일 경우 obj가 Person 타입의 객체란 소리
			return juminNo == ((Person)obj).juminNo;		
		} else {
			return false;
		}
	}
}
