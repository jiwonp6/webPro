package com.lex.ex;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		System.out.println("절댓값을 알고 싶은 수를 입력하세요 : ");
		su = sc.nextInt();
		
		System.out.printf("%d의 절댓값은 %d이다.", su, num(su));
		
		sc.close();
	}
	private static int num (int su) {
		int result = (su>=0) ? (su) : (-su);
		return result;
	}
}
