package com.lex.method;

public class Arithmetic {
	public int abs(int value) {	//abs는 static 메소드 아님!(일반 메소드)
		int result = (value >= 0) ? value : -value;
		return result;
	}	
//	<메소드1>	//1~to까지 누적한 결과 return
	public static int sum(int to) {	
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
//	<메소드2>	
	public static int sum(int from, int to) {	
		int result = 0;
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
//	<메소드3>
	public static String evenOdd(int value) {
		return value%2==0 ? "짝수입니다." : "홀수입니다.";
	}
}
