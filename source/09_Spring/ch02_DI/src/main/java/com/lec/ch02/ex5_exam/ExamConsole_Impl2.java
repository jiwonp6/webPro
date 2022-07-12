package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExamConsole_Impl2 implements ExamConsole {
	private Exam exam2;
	public void print() {
		System.out.println("이름 : "+exam2.getName());
		System.out.println("총점 : "+exam2.total());
		System.out.printf("평균 :%5.1f", exam2.avg());
	}

}
