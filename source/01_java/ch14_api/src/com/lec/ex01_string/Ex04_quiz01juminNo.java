package com.lec.ex01_string;

import java.util.Scanner;

public class Ex04_quiz01juminNo {
	public static void main(String[] args) {
		String juminNo;
		System.out.println("�ֹ� ��ȣ�� �Է��ϼ���('-'�� �־� �Է����ּ���) :");
		Scanner sc = new Scanner(System.in);
		juminNo = sc.next();
		if(juminNo.charAt(7)=='2'||juminNo.charAt(7)=='4') {
			System.out.println("�����Դϴ�.");
		}else if(juminNo.charAt(7)=='1'||juminNo.charAt(7)=='3') {
			System.out.println("�����Դϴ�.");
		}else
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	}
}
