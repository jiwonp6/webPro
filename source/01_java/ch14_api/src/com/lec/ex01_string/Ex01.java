package com.lec.ex01_string;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		String str1 = "Java";
		String str2 = "Java";
		String str3 = new String("Java");	//������ ��ü ����
		//String�� new�� �������� �ʰ� " "�� ����� ���ڿ� ����� �̿�
		//�ڵ����� heap ������ String ��ü ������
			//->(�̶�, �̹� �����ϴ��� Ȯ�� �� �����ϸ� ���� �����ؼ� ��)
				//->(�������� ������ String ��ü ����)
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҰ��� ����");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҰ��� ����");
		}
		if(str1.equals(str2)) {
			System.out.println("���� ���ڿ�");
		}
		System.out.println(str1==str3 ? "str1�� str3�� ���� �ּҰ�" : "str1�� str3�� �ٸ� �ּҰ�");
		System.out.println(str1.equals(str3) ? "str1�� str3�� ���� ��Ʈ��" : "str1�� str3�� �ٸ� ���ڿ�");
	}
}
