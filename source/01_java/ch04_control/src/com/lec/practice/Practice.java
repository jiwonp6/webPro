package com.lec.practice;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		int num1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수를 입력하세요 : ");
		num1 = sc.nextInt();
		
		System.out.println(num1>=0 ? num1:-num1);
		
		sc.close();
	}
}
