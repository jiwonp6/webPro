package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���������� �Է��ϼ��� : "); 
		int kor = scanner.nextInt();
		System.out.print("���������� �Է��ϼ��� : "); 
		int mat = scanner.nextInt();
		System.out.print("���������� �Է��ϼ��� : "); 
		int eng = scanner.nextInt();
		
		int sum = kor + mat + eng;
		
		double avg = sum/3.0;
		
		System.out.printf("\n����:%d�� \t ����:%d�� \t ����:%d�� "
							+ "\n����:%d�� \n���:%.2f��",
								kor, mat, eng, sum, avg);
		scanner.close();
	}
}
