package com.lec.practice;

import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		int kor, mat, eng;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���������� �Է��ϼ��� : ");
		kor = sc.nextInt();
		System.out.println("���������� �Է��ϼ��� : ");
		mat = sc.nextInt();
		System.out.println("���������� �Է��ϼ��� : ");
		eng = sc.nextInt();
		
		double avg = (kor+mat+eng)/3.0;
		
		System.out.printf("������� : %.2f", avg);
		if(kor >= avg) {
			System.out.println("���������� ����̻�");
		}else {
			System.out.println("���������� ��չ̸�");
		}//��������
		if(mat >= avg) {
			System.out.println("���������� ����̻�");
		}else {
			System.out.println("���������� ��չ̸�");
		}//��������
		if(eng >= avg) {
			System.out.println("���������� ����̻�");
		}else {
			System.out.println("���������� ��չ̸�");
		}//��������
		sc.close();
	}
}
