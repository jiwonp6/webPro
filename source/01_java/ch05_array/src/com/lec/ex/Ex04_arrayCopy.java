package com.lec.ex;
//for문을 이용한 배열복사
public class Ex04_arrayCopy {
	public static void main(String[] args) {
		int[] score = {100, 10, 20, 30, 40};
		int[] s = new int[score.length];
		for(int idx=0 ; idx<score.length ; idx++) {
			s[idx] = score[idx];
		}
		//수정 후
		s[0] = 99;
		for(int idx=0 ; idx<score.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
	}
	}
