package com.lec.ch02.ex5_exam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ExamTestMain2 {

	public static void main(String[] args) {
		String location = "classpath:applicationCTX5.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		System.out.println("수정전");
		ExamConsole console = ctx.getBean("examConsole", ExamConsole.class);
		console.print();
		ctx.close();
		System.out.println("\n수정후");
		ExamConsole console2 = ctx.getBean("examConsole2", ExamConsole.class);
		console2.print();
		ctx.close();
	}
}
