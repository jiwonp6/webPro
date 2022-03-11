package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : "); 
		int su = scanner.nextInt();
		
		String result = su >= 65 ? "경로우대" : "일반";
		System.out.println(result);
		
		scanner.close();
	}
}
