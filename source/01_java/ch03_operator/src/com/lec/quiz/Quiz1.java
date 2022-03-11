package com.lec.quiz;
//사용자로부터 입력받은 수가 3의 배수인지 여부 출력
import java.util.Scanner; //Scanner는 많이 안써서 사용할 것이라고 먼저 선언해줘야한다.

public class Quiz1 {
	public static void main(String[] args) {
		//int i = 10 ;
		//String name = "홍길동";
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요 : "); //정수 입력 받기
		int su = scanner.nextInt();//사용자로부터 입력 받기
		String result = su%3 == 0 ? "입력하신 수는 3의 배수 입니다." : "입력하신 수는 3의 배수가 아닙니다.";
		System.out.println(result);
		
		scanner.close();
	}
}
