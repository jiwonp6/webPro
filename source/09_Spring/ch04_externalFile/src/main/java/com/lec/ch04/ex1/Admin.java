package com.lec.ch04.ex1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.Data;
@Data
public class Admin implements EnvironmentAware, InitializingBean{
	private String adminId;
	private String adminPw;
	private Environment env;
	@Override
	public void setEnvironment(Environment environment) {	//bean 생성하자마자 실행 1
		env = environment;	
	}
	@Override
	public void afterPropertiesSet() throws Exception {		//bean 생성하자마자 실행 2
		adminId = env.getProperty("admin.id");
		adminPw = env.getProperty("admin.pw");
	}
	
	
}
