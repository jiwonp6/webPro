package com.lec.condition;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		int kor, mat, eng;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요 : ");
		kor=sc.nextInt();
		System.out.println("수학 점수를 입력하세요 : ");
		mat=sc.nextInt();
		System.out.println("영어 점수를 입력하세요 : ");
		eng=sc.nextInt();
		
		double avg = (kor+mat+eng)/3.0;
		
		if(kor >= avg) {
			System.out.printf("국어점수 평균점수(%3.1f) 이상\n", avg);
		}else {
			System.out.printf("국어점수 평균점수(%3.1f) 미만\n", avg);
		}
		if(mat >= avg) {
			System.out.printf("수학점수 평균점수(%3.1f) 이상\n", avg);
		}else {
			System.out.printf("수학점수 평균점수(%3.1f) 미만\n", avg);
		}
		if(eng >= avg) {
			System.out.printf("영어점수 평균점수(%3.1f) 이상\n", avg);
		}else {
			System.out.printf("영어점수 평균점수(%3.1f) 미만\n", avg);
		}
		sc.close();
	}
}
