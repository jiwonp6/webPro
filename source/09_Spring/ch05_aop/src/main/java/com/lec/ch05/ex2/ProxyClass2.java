package com.lec.ch05.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect 	//ProxyClass라고 선언해주는 어노테이션
public class ProxyClass2 {
	/* //위빙과정
	 * @Pointcut("within(com.lec.ch05.ex2.*)")		//pointCut 지정
	 * private void aroundM() {}
	 * @Around("aroundM()")
	 * */
	
	//위빙과정(한 줄로)
	@Around("within(com.lec.ch05.ex2.*)")
	//aroundAdvice : 핵심기능 전후로 공통기능 수행
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("★★★★★★★★<aroundAdvice>★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toString();	//핵심기능 메소드명
		System.out.println(signatureName+"가 시작되었습니다");
		long startTime = System.currentTimeMillis();	//시작시점
		Object obj;
		try {
			//핵심기능 수행
			System.out.println("<<<핵심기능 수행중>>>");
			obj = joinPoint.proceed();	//obj => joinPoint(핵심기능) 실행 한 것 / 핵심기능에서 에러가 날 수 있으므로 try-catch
			return obj;
		} finally {
			//핵심기능 수행 이후 할 것
			long endTime = System.currentTimeMillis();	//끝나는 시점
			System.out.println("<<<핵심기능 수행 후 하는일>>>");
			System.out.println(signatureName+"가 수행되는 경과 시간 : "+(endTime-startTime));
		}
	}
	
	//beforeAdvice
	@Before("execution(* com.lec.ch05.ex2.Student2.*())")
	public void beforeAdvice() {
		System.out.println("● ● ● ● ● 핵심기능 수행하기 전 알아서 beforeAdvice(공통기능) 수행");
	}
	
	//afterAdvice
	@After("bean(student*)")
	public void afterAdvice() {
		System.out.println("◆ ◆ ◆ ◆ ◆ 핵심기능 수행하고 알아서 afterAdvice(공통기능) 수행");
	}
	
	//after-returning Advice
	@AfterReturning("within(com.lec.ch05.ex2.Worker2)")
	public void afterReturningAdvice() {
		System.out.println("▲ ▲ ▲ ▲ ▲ 정상적으로(예외발생X) 핵심기능이 수행된 후 이 afterReturningAdvice 수행");
	}
	
	//after-throwing Advice
	@AfterThrowing("execution(void com.lec.ch05.ex2.Worker2.get*())")
	public void afterThrowingAdvice() {
		System.out.println("■ ■ ■ ■ ■ 예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice 수행");
	}
}
