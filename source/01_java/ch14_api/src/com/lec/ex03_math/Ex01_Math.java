package com.lec.ex03_math;

public class Ex01_Math {
	public static void main(String[] args) {
		int a = 2, b = 10;
		System.out.println("2�� 10���� : "+ Math.pow(a,b));
		System.out.println("-9.9�� ���밪 : "+ Math.abs(-9.9));
		System.out.println("2�� �������� : "+ Math.sqrt(4));
		System.out.println("a�� b�� �ּҰ��� : "+ Math.min(a, b));
		System.out.println("a�� b�� �ִ밪�� : "+ Math.max(a, b));
		// Math�� ���� ( static final ����)
		System.out.println("PI ���� ? "+ Math.PI);
	}
}
