package com.lec.ch05.ex1;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyClass {
	//aroundAdvice : 핵심기능 전후로 공통기능 수행
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("★★★★★★★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toString();	//핵심기능 메소드명
		System.out.println(signatureName+"가 시작되었습니다");
		long startTime = System.currentTimeMillis();	//시작시점
		Object obj;
		try {
			//핵심기능 수행
			obj = joinPoint.proceed();	//obj => joinPoint(핵심기능) 실행 한 것 / 핵심기능에서 에러가 날 수 있으므로 try-catch
			return obj;
		} finally {
			//핵심기능 수행 이후 할 것
			long endTime = System.currentTimeMillis();	//끝나는 시점
			System.out.println(signatureName+"가 수행되는 경과 시간 : "+(endTime-startTime));
		}
	}
	//beforeAdvice
	public void beforeAdvice() {
		System.out.println("핵심기능 수행하기 전 알아서 beforeAdvice(공통기능) 수행");
	}
	//afterAdvice
	public void afterAdvice() {
		System.out.println("핵심기능 수행하고 알아서 afterAdvice(공통기능) 수행");
	}
	//after-returning Advice
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외발생X) 핵심기능이 수행된 후 이 afterReturningAdvice 수행");
	}
	//after-throwing Advice
	public void afterThrowingAdvice() {
		System.out.println("예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice 수행");
	}
}
