package com.lec.ex;

public class Ex03_reference {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		j = 99;
		System.out.printf("i=%d, j=%d\n", i, j);
		
		int[] score = {100, 10, 20, 30, 40};
		int[] s = score; //s바꾸면 score까지 바뀜
		//s가 score의 주소를 복사한 것이기 때문!
		//즉, 가르키는 것이 같기 때문에 똑같이 바뀜
		//바꾸고 싶지 않을 때는 s를 score의 값을 카피 해서 따로 분리해야함
		s[0] = 99;
		for(int idx=0 ; idx<score.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
	}
}
