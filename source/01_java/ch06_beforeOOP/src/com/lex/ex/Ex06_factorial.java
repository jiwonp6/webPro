package com.lex.ex;
//����ڷκ��� ���� �Է¹޾� (�Է¹��� ��)! = ans (���丮�� ����ϴ� �޼ҵ� �̿�) 
import java.util.Scanner;

public class Ex06_factorial {
	public static void main(String[] args) {
		int su;
		Scanner scanner = new Scanner(System.in);
		do {	
			System.out.print("����� �Է��ϼ���. : ");
			su = scanner.nextInt();
		}while(su<=0);
		
		long result = factorial(su);
		System.out.println("�Է��Ͻ� "+su+"! = "+result);
		System.out.printf("�Է��Ͻ� %d! = %d", su, result);
	}	//����� �Լ� ȣ��(���� ���� �� ȣ��)
	private static long factorial(int su) {	// su�� 1�ʰ��� ��� su * factorial(su-1)
		if(su==1) {
			return 1;
		}else {
			return su * factorial(su-1);	// <----����� �Լ� ȣ��(���� ���� �� ȣ��)
		}
	}
	
	
//	private static long factorial(int su) {	//���� su�ʹ� �ٸ� su��, �ٸ� ���̱� ����
//		int result = 1;
//		for (int i=su ; i>=1 ; i--) {
//			result *= i;
//		}
//		return result;
//	}
}
