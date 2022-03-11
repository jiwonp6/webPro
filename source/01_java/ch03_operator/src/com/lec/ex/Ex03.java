package com.lec.ex;
// 관계연산자(비교연산자) >, >=, <, <=, ==(같다), !=(다르다)
public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10, n2 = 20;
		boolean result;
		result = n1 > n2;
		System.out.printf("%d %c %d = %b\n", n1, '>', n2, result);
		result = n1 == n2;
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result); 
		// ==는 문자가 아니라 문자열이어서 ""랑  %s 써야한다.
	}
}
