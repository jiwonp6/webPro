package com.lec.quiz;
//ArrayList
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		ArrayList<Member> mbs = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("ȸ���� �߰��Ͻðڽ��ϱ�(y/n)");
			if(!sc.next().equalsIgnoreCase("y")) {
				break;
			}else{
			System.out.println("�̸� : ");
			String name = sc.next();
			System.out.println("��ȭ��ȣ : ");
			String tel = sc.next();
			System.out.println("�ּ� : ");
			sc.nextLine();
			String address = sc.nextLine();
			mbs.add(new Member(name, tel, address));
			}
		}while(true);
		if(mbs.size()==0) {
			System.out.println("������ ȸ�� ����");
		}else {
			for(int i=0; i<mbs.size(); i++) {
				System.out.println(mbs);
			}
		}
	}
}
