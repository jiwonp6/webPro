package com.lec.ch04.ex1;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTextMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	//컨테이너 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();	//env의 속성과 속성값 set
		try {
			//외부 설정 파일을 env안의 propertySources에 추가
			String loc = "classpath:META-INF/ex1/admin.properties";
			propertySources.addLast(new ResourcePropertySource(loc));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id = "+env.getProperty("admin.id"));
		System.out.println("admin.pw = "+env.getProperty("admin.pw"));
		//env에 외부 설정파일 속성들을 추가한 후 Bean생성
		ctx.load("classpath:META-INF/ex1/applicationCTX1.xml");
		ctx.refresh();
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println(admin);
		System.out.println("adminId : "+admin.getAdminId());
		System.out.println("adminPw : "+admin.getAdminPw());
		ctx.close();
	}

}
