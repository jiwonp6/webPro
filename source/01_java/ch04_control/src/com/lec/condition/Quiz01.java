package com.lec.condition;

import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		int num1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �Է��ϼ���");
		num1 = sc.nextInt();
		
		if(num1 >= 0){
			System.out.println("���� : " + num1);
		} else {
			System.out.println("���� : "+(-num1));
		}
	}
}
