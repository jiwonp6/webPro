package com.lec.loop;
//�ϰ� �� ������ ���������������� �ϴ� ���α׷� ���� 
import java.util.Scanner;

public class Quiz05_while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, com;
		do {
			com = (int)(Math.random()*3);
			System.out.println("����(0), ����(1), ��(2) �� �ϳ� ����");
			num = sc.nextInt();
			if (num == 0) {
				System.out.print("����� ����\t");
			} else if (num == 1) {
				System.out.print("����� ����\t");
			} else if (num == 2) {
				System.out.print("����� ���ڱ�\t");
			} else {
				System.out.print("����� �߸� �¾��. ����");
				num = 3; // ������ ���� ����
			} // if - you���
			if (num != 3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���
				String msg = (com == 0) ? "���� ����" : (com == 1) ? "���� ����" : "���� ���ڱ�";
				System.out.println(msg);
				// ����� ���� 3���� : ����, �̰��, ����
				if( (num+1)%3 == com) {
					System.out.println("����� ����� ");
					break;
				}else if(num == com ) {
					System.out.println("����");
				}else {
					System.out.println("����� �̰��� ");
				}
			}
			}while(true);
			System.out.println("��");	
			sc.close();
		}
}
	

