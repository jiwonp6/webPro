package com.lec.quiz2;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestMain2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String name = null;
		String tel = null;
		String address = null;
		String birth = null;
		Date today = new Date();
		String key;
		
		HashMap<String, Customer> member = new HashMap<String, Customer>();
			while (true) {
				System.out.println("ȸ�������� �Ͻðڽ��ϱ�?(y/n)");
				String ans = sc.next();
				if (ans.equalsIgnoreCase("y")) {
					System.out.println("�̸� : ");
					name = sc.next();
					System.out.println("��ȭ : ");
					tel = sc.next();
					System.out.println("�������(YYYY/MM/dd) :");
					birth = sc.next();
					System.out.println("�ּ� : ");
					sc.nextLine();
					address = sc.nextLine();
					StringTokenizer tok = new StringTokenizer(birth, "/");
					while (tok.hasMoreElements()) {
						int year = (Integer.parseInt(tok.nextToken()) - 1900);
						int month = (Integer.parseInt(tok.nextToken()) - 1);
						int day = Integer.parseInt(tok.nextToken());
						if (month == today.getMonth() && day== today.getDate()) {
							System.out.println(name + "�� ���������մϴ�");
						}
					}
					System.out.println("���ԿϷ�\n");
					member.put(tel, new Customer(name, tel, birth, address));
				} else if(ans.equalsIgnoreCase("n")){
					break;
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
					continue;
				}
			}
			String line = "\n";
			String str = "\t\t" + "-----�̻� " + member.size() + "�� ȸ������-----";
			Iterator<String> iterator = member.keySet().iterator();
			while(iterator.hasNext()) {
				key = iterator.next();
				System.out.println(member.get(key));
			}
			System.out.println("\t\t" + "-----�̻� " + member.size() + "�� ȸ������-----");
		
		sc.close();
		
	}
}