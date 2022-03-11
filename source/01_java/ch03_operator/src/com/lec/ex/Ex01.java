package com.lec.ex;
//산술연산자 : + - * / %(나머지)
public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result; //+-*%의 결과
		double resultDouble; // /(몫)의 결과
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result); // 33+10=43, 문자는 %c,숫자는 %d
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result); 
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result); 
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result); 
		resultDouble = (double)n1 / n2; // resultDouble은 8byte, n1/n2는 4byte이므로 (double) 안하면 정수로 나옴
		System.out.printf("%d %c %d = %f\n", n1, '/', n2, resultDouble);  // double은 %f
		if(n1%2 == 0) {
			System.out.println("n1은 짝수");
		}
		else {
			System.out.println("n1은 홀수");
		} // if문
		if (n1%5 == 0)
			System.out.println("n1은 5의 배수");
		else
			System.out.println("n1은 5의 배수가 아님");
		
	}
}
