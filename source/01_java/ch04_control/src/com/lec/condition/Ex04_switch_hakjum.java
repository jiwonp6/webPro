package com.lec.condition;

import java.util.Scanner;

public class Ex04_switch_hakjum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� : ");
		int score = scanner.nextInt();
		int temp = score==100? score-1 : score; //100���� ��� case10���� �νĵǹǷ� ��������
		temp = (-9<=temp && temp<0) ? -10 : temp; //-9���� -1���� case1�� �νĵǹǷ� ��������
		
		switch(score/10) {
			// case 10 : //100���� ��� case10�� break��� case9�� ����� cf.101���� ���
			case 9 : System.out.println("A����"); break;
			case 8 : System.out.println("B����"); break;
			case 7 : System.out.println("C����"); break;
			case 6 : System.out.println("D����"); break;
			case 5 : case 4: case 3 : case 2 : case 1 : case 0 :
				 	 System.out.println("F����"); break;
			default : 
				System.out.println("��ȿ���� �ʴ� �����Դϴ�.");
		}
		scanner.close();
	}
}
