package com.lex.ex;
//������ ����
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		int su;
		Scanner scanner = new Scanner(System.in);
		
		do {	
			System.out.println("�������� ������ 2~9������ ������ �Է��ϼ��� : ");
			su = scanner.nextInt();
		}while(su<2 || su>9);
		System.out.printf("<������ %d��>\n", su);
		
		num(su);	//��� �ҷ����� â
		scanner.close();
	}
	
//������ method	
	private static void num(int su)  {
		int result = 1;
		for(int i=1 ; i<=9 ; i++) {
			result = su * i;
			System.out.printf("%d * %d = %d\n", su, i, result);
		}
	}
	
}
