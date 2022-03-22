package com.lec.quiz01;
//(번호)st101  (ID)A01	(이름):강유미	(반)JAVA반
//(번호)st102  (ID)A02	(이름):홍길동	(반)C++반
public class Student extends Person{
	private String ban;
	private static int count;
	Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		int studentNum=1;
		studentNum = ++count;
		System.out.print("(번호)st10"+studentNum+"\t(ID)"+id+"\t(이름)"+name+"\t(반)"+ban);
		System.out.println();
	}
}

//학생번호를 매길 때 st10을 붙여주어야 한다.
//이것을 print 안에 직접 넣어주면 수정하기에 불편...
//따로 빼주어서 String 값으로 다시 받는 것이 수정하기에 좋다.