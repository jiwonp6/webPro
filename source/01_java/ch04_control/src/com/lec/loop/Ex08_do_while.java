package com.lec.loop;
//¦���� �Է¹޴� ���α׷� ����
import java.util.Scanner;
public class Ex08_do_while {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("¦���� �Է��ϼ��� : ");
			num = sc.nextInt();
		}while(num%2 != 0);
		System.out.println("�Է��Ͻ� ���� ¦�� "+num+"�Դϴ�.");
		sc.close();
	}
}
