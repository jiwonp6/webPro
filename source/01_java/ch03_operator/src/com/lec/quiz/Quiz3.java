package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : "); 
		int su1 = scanner.nextInt();
		System.out.print("���� �Է��ϼ��� : ");
		int su2 = scanner.nextInt();
		String result1 = su1 == su2 ? "O" : "X";
		System.out.println("�� ���� ������? "+result1);
		
		String result2 = su1 > su2 ? "O" : "X";
		System.out.println("�� �� �� ù��° ���� �� ū��? " +result2);
		
		scanner.close();
	}

}
