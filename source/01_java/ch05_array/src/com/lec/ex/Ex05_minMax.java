package com.lec.ex;

import java.util.Scanner;
//1. ����ڷ� ���� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾� ���Ű ���
// 2. ����� ģ�� �̸��� Ű, �ִܽ� ģ���̸��� Ű ���
public class Ex05_minMax {
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
		
		int minHeight = 999, minIdx=0;	//�ִܽ�Ű�� �ε���(��ġ) ����
		int maxHeight = 0, maxIdx=0; 	//�����Ű�� �ε���(��ġ) ����
		for(int i=0 ; i<arrName.length ; i++) {
			if(arrHeight[i]<minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
				}//if - �ִܽ�Ű�� �ִܽ� �ε��� ã��
			if(arrHeight[i]>maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
				}//if - �����Ű�� ����� �ε��� ã��
			}//for
		System.out.println("�ִܽ��� "+arrName[minIdx]+"�̰�, Ű�� " + minHeight+"�Դϴ�.");
		System.out.println("������� "+arrName[maxIdx]+"�̰�, Ű�� " + maxHeight+"�Դϴ�.");
	}
}
