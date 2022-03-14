package com.lec.loop;
//구구단 5단 출력
public class Quiz03 {
	public static void main(String[] args) {
		int tot = 1;
		for(int i=1;i<=10;i++) {
			tot = 5*i;
			System.out.printf("5 * %d = %d\n", i, tot );
		}
	}
}
