package com.lec.ex06_wrapper;

import java.util.Scanner;

// ����ڷκ��� �������ڿ�(" 100 ")�� �Է¹޾� ������ �����ؼ� ����ϴ� ���α׷�
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		String numStr = sc.nextLine();
		System.out.println("�Է��Ͻ� ���ڿ��� : "+ numStr);
		numStr = numStr.trim(); // �¿� space ����
		numStr = numStr.replace("[a-zA-Z��-�R]", "");  //���� ����
		int num = Integer.parseInt(numStr);
		System.out.println("������ ������ "+ num);
		
		
		
		
	}
	

}
