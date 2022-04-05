package com.lec.ex03_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6, "이순신");
		students.add(s);
		students.add(s);
		students.add(new Student(3, "홍길동"));	
		students.add(new Student(3, "홍길동"));	//홍길동이 두 번 들어가짐...
		students.add(new Student(6, "이순신"));	//이순신도 두 번 들어가짐...
		//즉, 서로 다른 객체로 인식해서 여러번 들어가버림<-잘못된 방법
			//(Set은 같은걸로 인식해서 들어가지지 말아야한다)
				//=>set은 서로 hashcode비교, equals비교해서 둘 다 똑같으면 제거
		System.out.println(students);
	}
}
