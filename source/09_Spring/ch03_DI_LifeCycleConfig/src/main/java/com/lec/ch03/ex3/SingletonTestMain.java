package com.lec.ch03.ex3;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.ex1.Family;

public class SingletonTestMain {

	public static void main(String[] args) {
		String location = "classpath:META-INF/ex3/applicationCTX1.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		Family family1 = ctx.getBean("family", Family.class);
		Family family2 = ctx.getBean("family", Family.class);
		family1.setPapaName("박아빠");
		family1.setMamiName("박엄마");
		System.out.println("family1 : "+family1);
		System.out.println("family2 : "+family2);
		if(family1.equals(family2)) {
			System.out.println("family1과 family2는 같다");
		}else {
			System.out.println("family1과 family2는 다르다");
		}
		System.out.println("-------------------------------------------");
		Family family3 = ctx.getBean("familyPrototype", Family.class);
		Family family4 = ctx.getBean("familyPrototype", Family.class);
		family3.setSisterName("요놈요놈");
		family3.setBrotherName("요놈의 자식");
		System.out.println("family3 : "+family3);
		System.out.println("family4 : "+family4);
		if(family3.equals(family4)) {
			System.out.println("family3과 family4는 같다");
		}else {
			System.out.println("family3과 family4는 다르다");
		}
	}

}
