package com.lec.practice;

import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		int kor, mat, eng;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어점수를 입력하세요 : ");
		kor = sc.nextInt();
		System.out.println("수학점수를 입력하세요 : ");
		mat = sc.nextInt();
		System.out.println("영어점수를 입력하세요 : ");
		eng = sc.nextInt();
		
		double avg = (kor+mat+eng)/3.0;
		
		System.out.printf("평균점수 : %.2f", avg);
		if(kor >= avg) {
			System.out.println("국어점수는 평균이상");
		}else {
			System.out.println("국어점수는 평균미만");
		}//국어점수
		if(mat >= avg) {
			System.out.println("수학점수는 평균이상");
		}else {
			System.out.println("수학점수는 평균미만");
		}//수학점수
		if(eng >= avg) {
			System.out.println("영어점수는 평균이상");
		}else {
			System.out.println("영어점수는 평균미만");
		}//영어점수
		sc.close();
	}
}
