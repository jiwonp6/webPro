package com.lex.ex;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �˰� ���� ���� �Է��ϼ��� : ");
		su = sc.nextInt();
		
		System.out.printf("%d�� ������ %d�̴�.", su, num(su));
		
		sc.close();
	}
	private static int num (int su) {
		int result = (su>=0) ? (su) : (-su);
		return result;
	}
}
