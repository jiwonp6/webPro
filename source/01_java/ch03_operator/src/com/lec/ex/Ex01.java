package com.lec.ex;
//��������� : + - * / %(������)
public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result; //+-*%�� ���
		double resultDouble; // /(��)�� ���
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result); // 33+10=43, ���ڴ� %c,���ڴ� %d
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result); 
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result); 
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result); 
		resultDouble = (double)n1 / n2; // resultDouble�� 8byte, n1/n2�� 4byte�̹Ƿ� (double) ���ϸ� ������ ����
		System.out.printf("%d %c %d = %f\n", n1, '/', n2, resultDouble);  // double�� %f
		if(n1%2 == 0) {
			System.out.println("n1�� ¦��");
		}
		else {
			System.out.println("n1�� Ȧ��");
		} // if��
		if (n1%5 == 0)
			System.out.println("n1�� 5�� ���");
		else
			System.out.println("n1�� 5�� ����� �ƴ�");
		
	}
}
