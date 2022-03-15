package com.lex.ex;
//1~10까지 정수의 합 출력하고, 그 합이 짝수인지 홀수인지 출력
public class Ex01 {
	public static void main(String[] args) {
		int tot=0;
		for(int i=1 ; i<=10 ; i++) {
			tot += i;
		}
		System.out.printf("1~10까지 정수의 합은 %d입니다.\n", tot);
		String msg;
		if(tot%2 == 0) {
			msg = "짝수입니다.";
		}else {
			msg = "홀수입니다.";
		}
		System.out.println("합 "+tot+"는 "+msg);
	}
}
