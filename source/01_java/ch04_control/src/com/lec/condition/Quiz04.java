package com.lec.condition;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		int num;
		String ans;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ���� ���� ���ڷ� �Է��ϼ��� : \n(������ 0, ������ 1, ���� 2 �Դϴ�.)");
		num = sc.nextInt();
		if(num==0) {
			System.out.println("����");
		}else if(num==1){
			System.out.println("����");
		}else if(num==2){
			System.out.println("��");
		}else
			System.out.println("��ȿ���� ���� ���Դϴ�.");
		sc.close();
	}
}
