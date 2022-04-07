package com.lec.ex01_trycatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
	// 예외처리 추가
		Scanner sc = new Scanner(System.in);
		System.out.print("사칙연산을 할 첫번째 수는 ? : ");
		int i = sc.nextInt(); 
		System.out.print("사칙연산을 할 두번째 수는 ? : ");
		int j = sc.nextInt(); 
		System.out.println("i= "+i+", j= "+j);
		System.out.println("i * j = "+ (i*j));
		try {  // try에는 예외가 발생할 수 있는 부분 
		System.out.println("i / j = "+ (i/j)); // 예외가 발생할 수 있는 부분
		} catch(ArithmeticException e) { // catch 안에는 예외가 발생할 경우 우회적으로 수행할 로직
			// catch() 괄호안에 상위단계인 Exception e 를 넣어도 같음 다 상속받은거라 확인은 컨트롤+t
			System.out.println("예외 메세지 : "+e.getMessage());
	//		e.printStackTrace(); // 자세한 예외 메시지 출력
		}
		System.out.println("i + j = "+ (i+j));
		System.out.println("i - j = "+ (i-j));
		System.out.println("DONE");
		sc.close();
	}
}
