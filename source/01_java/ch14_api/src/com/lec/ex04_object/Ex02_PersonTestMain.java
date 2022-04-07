package com.lec.ex04_object;

public class Ex02_PersonTestMain {
	public static void main(String[] args) {
		Person p1 = new Person(9512121021021L);
		Person p2 = new Person(9512121021021L);
		Person p3 = null;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람");
		} else {
			System.out.println("p1과 p2는 다른 사람");
		}
		
		if( p1 == p2) {
			System.out.println("p1과 p2는 같은 주소 ");
		} else {
			System.out.println("p1과 p2는 다른 주소");
		}
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		
	}
}
