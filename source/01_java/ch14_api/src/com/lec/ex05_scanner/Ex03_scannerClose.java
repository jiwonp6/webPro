package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {
	private static void nickName() { // ����ڷκ��� ������ �޾� ����ϴ� �޼ҵ�
		Scanner scNickName = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		System.out.println("�Է��Ͻ� ������ : "+ scNickName.nextLine());
		
	}
	
	public static void main(String[] args) {
		 // BookLib ��ü ���� ����ڿ��� ���� or �ݳ�
		Scanner scMain = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = scMain.nextLine();
		System.out.println("�Է��Ͻ� �̸��� : "+ name);
		nickName();
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = scMain.nextInt();
		System.out.println("�Է��Ͻ� ���̴� : "+ age);
		scMain.close();
		
		
		
	}

}
