package com.lec.quiz;

import java.util.Scanner;

public class Quiz6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System. in);
		System.out.println("�����ϴ� ���ڰ� ������?");
		int su = scanner.nextInt();
		
		String result = su == 5 ? "���� ���׿�." : "���� �ٸ��׿�.";
		System.out.println(result);
		scanner.close();
	}

}
