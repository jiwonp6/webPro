package com.lec.ex;

import java.util.Scanner;
// 1. ����ڷ� ���� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾� ���Ű ���
public class Ex05_HeightAvg {
	public static void main(String[] args) {
		String[] arrName = {"����", "ö��", "�浿", "����", "����"};
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0;	// �Է¹��� Ű ���� ����
		for(int idx=0 ; idx < arrName.length ; idx++) {
			System.out.print(arrName[idx]+"�� Ű�� : ");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("���Ű�� "+(double)totalHeight/arrName.length);
		
		sc.close();
	}
}
