package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("ȸ���� �߰��Ͻðڽ��ϱ�(y/n)");
			if(!sc.next().equalsIgnoreCase("y")) {
				break;
			}else {
				System.out.println("�̸� : ");
				String name = sc.next();
				System.out.println("��ȭ��ȣ : ");
				String tel = sc.next();
				if(hashMap.get(tel) != null) {
					System.out.println("������ȣ�� �̹� �����մϴ�");
					System.out.println(tel+"\t"+hashMap.get(tel));
				}else {
					System.out.println("�ּ� : ");
					sc.nextLine();
					String address = sc.nextLine();
					String id = name+"\t"+address;
					hashMap.put(tel, id);
				}
			}
		}while(true);	//do
		if(hashMap.size()==0) {
			System.out.println("������ ȸ�� ����");
		}else {
			Iterator<String> iterator = hashMap.keySet().iterator();	//hashMap�� keyset(��������)
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key+"\t"+hashMap.get(key));
			}
		}//else.last
	}//main
}



