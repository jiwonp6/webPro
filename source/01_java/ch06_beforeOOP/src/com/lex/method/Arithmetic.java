package com.lex.method;

public class Arithmetic {
	public int abs(int value) {	//abs�� static �޼ҵ� �ƴ�!(�Ϲ� �޼ҵ�)
		int result = (value >= 0) ? value : -value;
		return result;
	}	
//	<�޼ҵ�1>	//1~to���� ������ ��� return
	public static int sum(int to) {	
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
//	<�޼ҵ�2>	
	public static int sum(int from, int to) {	
		int result = 0;
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
//	<�޼ҵ�3>
	public static String evenOdd(int value) {
		return value%2==0 ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
	}
}
