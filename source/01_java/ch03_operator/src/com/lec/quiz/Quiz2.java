package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("���� �Է��ϼ��� : "); 
			int su = scanner.nextInt();
			String result = su%2 == 0 ? "�Է��Ͻ� ���� ¦�� �Դϴ�." : "�Է��Ͻ� ���� Ȧ�� �Դϴ�.";
			System.out.println(result);
			scanner.close();
		}
	}
