package com.lex.ex;
//구구단 실행
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		int su;
		Scanner scanner = new Scanner(System.in);
		
		do {	
			System.out.println("구구단을 수행할 2~9사이의 정수를 입력하세요 : ");
			su = scanner.nextInt();
		}while(su<2 || su>9);
		System.out.printf("<구구단 %d단>\n", su);
		
		num(su);	//결과 불러오는 창
		scanner.close();
	}
	
//구구단 method	
	private static void num(int su)  {
		int result = 1;
		for(int i=1 ; i<=9 ; i++) {
			result = su * i;
			System.out.printf("%d * %d = %d\n", su, i, result);
		}
	}
	
}
