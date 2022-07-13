package com.lec.ch03.ex2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements InitializingBean, DisposableBean, EnvironmentAware{
	private String name;
	private String tel;
	
	@Override	//InitializingBean
	public void afterPropertiesSet() throws Exception {
		System.out.println("Person형 빈 객체 생성하자마자 실행2 : afterPropertiesSet() 호출");
	}

	@Override	//DisposableBean
	public void destroy() throws Exception {
		System.out.println("Person형 빈 소멸 바로 전 실행 : destroy() 호출");
	}

	@Override	//EnvironmentAware	environment=ioc컨테이너
	public void setEnvironment(Environment environment) {
		System.out.println("Person형 빈 객체 생성하자마자 실행1 : setEnvironment() 호출");
	}
	
}
