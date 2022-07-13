package com.lec.ch03.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		// AbstractApplicationContext를 쓰면 load를 못씀
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	//컨테이너만! 생성(환경설정, IOC컨테이너 생성임)
		ctx.load("classpath:META-INF/ex2/applicationCTX1.xml");	//파싱
		ctx.refresh();	//빈 생성
		System.out.println("---------------------");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		OtherPerson otherPerson = ctx.getBean("otherPerson", OtherPerson.class);
		System.out.println(otherPerson);
		System.out.println("---------------------");
		ctx.close();
		System.out.println("빈소멸");
		
	}

}
