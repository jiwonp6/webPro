package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요 : "); 
		int su1 = scanner.nextInt();
		System.out.print("수를 입력하세요 : ");
		int su2 = scanner.nextInt();
		String result1 = su1 == su2 ? "O" : "X";
		System.out.println("두 수가 같은가? "+result1);
		
		String result2 = su1 > su2 ? "O" : "X";
		System.out.println("두 수 중 첫번째 수가 더 큰가? " +result2);
		
		scanner.close();
	}

}
