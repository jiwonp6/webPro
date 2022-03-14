package com.lec.condition;

import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		int num1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수를 입력하세요");
		num1 = sc.nextInt();
		
		if(num1 >= 0){
			System.out.println("절댓값 : " + num1);
		} else {
			System.out.println("절댓값 : "+(-num1));
		}
	}
}
