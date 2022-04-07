package com.lec.ex01_trycatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
	// ����ó�� �߰�
		Scanner sc = new Scanner(System.in);
		System.out.print("��Ģ������ �� ù��° ���� ? : ");
		int i = sc.nextInt(); 
		System.out.print("��Ģ������ �� �ι�° ���� ? : ");
		int j = sc.nextInt(); 
		System.out.println("i= "+i+", j= "+j);
		System.out.println("i * j = "+ (i*j));
		try {  // try���� ���ܰ� �߻��� �� �ִ� �κ� 
		System.out.println("i / j = "+ (i/j)); // ���ܰ� �߻��� �� �ִ� �κ�
		} catch(ArithmeticException e) { // catch �ȿ��� ���ܰ� �߻��� ��� ��ȸ������ ������ ����
			// catch() ��ȣ�ȿ� �����ܰ��� Exception e �� �־ ���� �� ��ӹ����Ŷ� Ȯ���� ��Ʈ��+t
			System.out.println("���� �޼��� : "+e.getMessage());
	//		e.printStackTrace(); // �ڼ��� ���� �޽��� ���
		}
		System.out.println("i + j = "+ (i+j));
		System.out.println("i - j = "+ (i-j));
		System.out.println("DONE");
		sc.close();
	}
}
