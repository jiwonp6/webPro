package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {	//Calculation에 의존
	public static void main(String[] args) {
		/* bean태그로 만들어 부품화(방법2)할 예정
		 * Calculation cal = new Calculation();
		 * cal.setNum1(50);
		 * cal.setNum2(10);
		 */
		//파싱하기위해 객체 생성
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
									//추상메소드라바로객체생성불가(스프링컨테이너 안에 넣음)//*classpath=resources패키지
		Calculation cal = ctx.getBean("calculation", Calculation.class);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		System.out.println(cal);
		ctx.close();	//스프링컨테이너 안 객체 삭제
	}
}
