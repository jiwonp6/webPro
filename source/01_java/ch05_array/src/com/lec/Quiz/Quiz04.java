package com.lec.Quiz;

public class Quiz04 {
	public static void main(String[] args) {
		int[] coin = {500, 100, 50, 10};
		int money = 2680;
		int num1;
		for(int i=0 ; i<coin.length ; i++){
			 num1 = money/coin[i];
			 money = money%coin[i];
			 System.out.printf("%d¿ø : %d°³\t", coin[i], num1);
			 
		}
	}
}
