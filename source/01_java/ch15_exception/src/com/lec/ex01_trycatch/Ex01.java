package com.lec.ex01_trycatch;

import java.util.Scanner;
// ����ó�� ����
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��Ģ������ �� ù��° ���� ? : ");
		int i = sc.nextInt(); // ���ܰ� �߻��� �� �ִ� �κ�
		System.out.print("��Ģ������ �� �ι�° ���� ? : ");
		int j = sc.nextInt(); // ���ܰ� �߻��� �� �ִ� �κ�
		System.out.println("i= "+i+", j= "+j);
		System.out.println("i * j = "+ (i*j));
		System.out.println("i / j = "+ (i/j)); // ���ܰ� �߻��� �� �ִ� �κ�
		System.out.println("i + j = "+ (i+j));
		System.out.println("i - j = "+ (i-j));
		System.out.println("DONE");
		sc.close();
	}
}
