package com.lec.quiz;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		String ans;
		String address = null;
		int i;
		Friend[] f1 = { new Friend("ȫ�浿", "����� ��걸", "010-9999-1234", "05-22"),
				new Friend("�ű浿", "��⵵ ȭ����", "010-8888-5678", "04-07"),
				new Friend("��浿", "����� ������", "010-9999-8524", "08-08")};

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			ans = sc.next();
			boolean searchOk = false;
			if (!ans.equalsIgnoreCase("x")) {
				for(i=0; i<f1.length; i++) {
					if(ans.equals(f1[i].getAddress().substring(0, 2))){
						System.out.println(f1[i].toString());
						searchOk=true;
					}
				}
				if(!searchOk){
					System.out.println("�ش� �ּ��� ģ���� �����ϴ�.\n");
				}
			}else {
				System.out.println("����");
				break;
			}
		}
	}
}
