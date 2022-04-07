package com.lec.ex01_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

// ����: ArithmeticException , InputMismatchException 
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.print("��Ģ������ �� ù��° ���� ? : ");
				i = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("���ܹ߻� : " + e.getMessage());
				System.out.println("������ �ݵ�� �Է��ϼ��� : ");
				sc.nextLine();
			}
		} while (true);

		System.out.print("��Ģ������ �� �ι�° ���� ? : ");
		try {
			j = sc.nextInt();
			System.out.println("i= " + i + ", j= " + j);
			System.out.println("i * j = " + (i * j));
			System.out.println("i / j = " + (i / j));
		} catch ( InputMismatchException e) {
			System.out.println("���ܹ߻� : "+e.getMessage());
			System.out.println("�ι�° ���� �߸� �Է��Ͻø� 1�� �ʱ�ȭ �˴ϴ�.");
		} catch ( ArithmeticException e) {
			System.out.println("���ܹ߻� : "+ e.getMessage());
		} catch ( Exception e ) { 
			System.out.println("��� ���ܴ� �� �������� : "+ e.getMessage());			
		}
		// catch ���� �� �����ؼ� ����
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		sc.close();
	}
}
