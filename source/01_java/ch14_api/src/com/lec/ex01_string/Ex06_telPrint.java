package com.lec.ex01_string;
//��ȭ��ȣ �Է� �޾�, �Է¹��� ��ȭ��ȣ, ¦����° ����, �Ųٷ�, ��ȭ��ȣ ���ڸ�, ��ȭ��ȣ ���ڸ�
import java.util.Scanner;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("��ȭ��ȣ �Է��ϼ��� : ");
			String tel = sc.next();	//string ����
			if(tel.equalsIgnoreCase("X"))
				break;
			System.out.println("�Է��� ��ȭ��ȣ : " + tel);
			System.out.print("¦����° ���ڿ� : ");
			for(int i=0; i<tel.length(); i++) {
				if(i%2 == 0) {
					System.out.print(tel.charAt(i));	//¦����° ���
				}else {
					System.out.print(" ");	//space���
				}
			}
			System.out.println();
			System.out.print("���ڸ� �Ųٷ�");
			for(int i=tel.length()-1; i>=0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			String pre ="��ȭ��ȣ ���ڸ�";
			String post = "��ȭ��ȣ ���ڸ�";
			String mid = "��ȭ��ȣ �߰��ڸ�";
			System.out.println("");
			pre = tel.substring(0,tel.indexOf("-"));
			System.out.print("��ȭ��ȣ ���ڸ� : "+pre);
			post = tel.substring(tel.lastIndexOf("-")+1);
			System.out.println("��ȭ��ȣ ���ڸ� : "+post);
			mid = tel.substring(tel.indexOf("-")+1,tel.lastIndexOf("-"));
			System.out.print("��ȭ��ȣ �߰��ڸ� : "+mid);
		}while(true);
	}
}
