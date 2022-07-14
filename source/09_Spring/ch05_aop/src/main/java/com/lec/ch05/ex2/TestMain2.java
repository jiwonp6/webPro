package com.lec.ch05.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain2 {
	public static void main(String[] args) {
		String location = "classpath:META-INF/applicationCTX2.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		Student2 student = ctx.getBean("student2", Student2.class);
		Worker2 worker = ctx.getBean("worker2", Worker2.class);
		student.getStudentInfo();	//핵심기능 구현
		System.out.println("++++++++++++++++++++++++++++++++++");
		worker.getWorkerInfo();	//핵심기능 구현
	}
}
