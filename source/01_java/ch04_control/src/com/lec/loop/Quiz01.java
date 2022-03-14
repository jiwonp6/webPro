package com.lec.loop;

public class Quiz01 {
	public static void main(String[] args) {
		int a =1;
		for(int i=1 ; i<=10 ; i++) {
			a = a*i;
		}
		System.out.println("1~10까지 누적 곱은 "+a);
	}
}
