package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수를 입력하세요 : "); 
		int kor = scanner.nextInt();
		System.out.print("수학점수를 입력하세요 : "); 
		int mat = scanner.nextInt();
		System.out.print("영어점수를 입력하세요 : "); 
		int eng = scanner.nextInt();
		
		int sum = kor + mat + eng;
		
		double avg = sum/3.0;
		
		System.out.printf("\n국어:%d점 \t 수학:%d점 \t 영어:%d점 "
							+ "\n총점:%d점 \n평균:%.2f점",
								kor, mat, eng, sum, avg);
		scanner.close();
	}
}
