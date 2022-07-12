package com.lec.ch02.ex3_student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentTestMain {
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);	//파싱
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getInfo();
		Student student1 = ctx.getBean("student1", Student.class);	//컴포넌트 가져옴
		//studentInfo.getInfo(); = Student student1
		if(student1.equals(studentInfo.getStudent())) {
			System.out.println("두 객체는 같다");
		}else {
			System.out.println("두 객체는 다르다");
		}
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);	//studentInfo안의 student를 student2로 세팅
		studentInfo.getInfo();
		ctx.close();
	}
}
