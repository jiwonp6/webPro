package com.lec.condition;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		int kor, mat, eng;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ������ �Է��ϼ��� : ");
		kor=sc.nextInt();
		System.out.println("���� ������ �Է��ϼ��� : ");
		mat=sc.nextInt();
		System.out.println("���� ������ �Է��ϼ��� : ");
		eng=sc.nextInt();
		
		double avg = (kor+mat+eng)/3.0;
		
		if(kor >= avg) {
			System.out.printf("�������� �������(%3.1f) �̻�\n", avg);
		}else {
			System.out.printf("�������� �������(%3.1f) �̸�\n", avg);
		}
		if(mat >= avg) {
			System.out.printf("�������� �������(%3.1f) �̻�\n", avg);
		}else {
			System.out.printf("�������� �������(%3.1f) �̸�\n", avg);
		}
		if(eng >= avg) {
			System.out.printf("�������� �������(%3.1f) �̻�\n", avg);
		}else {
			System.out.printf("�������� �������(%3.1f) �̸�\n", avg);
		}
		sc.close();
	}
}
