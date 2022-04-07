package com.lec.ex03_math;

public class Ex01_Math {
	public static void main(String[] args) {
		int a = 2, b = 10;
		System.out.println("2의 10승은 : "+ Math.pow(a,b));
		System.out.println("-9.9의 절대값 : "+ Math.abs(-9.9));
		System.out.println("2의 제곱근은 : "+ Math.sqrt(4));
		System.out.println("a와 b의 최소값은 : "+ Math.min(a, b));
		System.out.println("a와 b의 최대값은 : "+ Math.max(a, b));
		// Math의 변수 ( static final 변수)
		System.out.println("PI 값은 ? "+ Math.PI);
	}
}
