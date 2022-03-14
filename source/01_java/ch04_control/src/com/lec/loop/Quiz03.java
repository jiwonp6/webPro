package com.lec.loop;

public class Quiz03 {
	public static void main(String[] args) {
		int tot = 1;
		for(int i=1;i<=10;i++) {
			tot = 5*i;
			System.out.printf("5 * %d = %d\n", i, tot );
		}
	}
}
