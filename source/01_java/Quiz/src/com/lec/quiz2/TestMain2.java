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
				System.out.println("회원가입을 하시겠습니까?(y/n)");
				String ans = sc.next();
				if (ans.equalsIgnoreCase("y")) {
					System.out.println("이름 : ");
					name = sc.next();
					System.out.println("전화 : ");
					tel = sc.next();
					System.out.println("생년월일(YYYY/MM/dd) :");
					birth = sc.next();
					System.out.println("주소 : ");
					sc.nextLine();
					address = sc.nextLine();
					StringTokenizer tok = new StringTokenizer(birth, "/");
					while (tok.hasMoreElements()) {
						int year = (Integer.parseInt(tok.nextToken()) - 1900);
						int month = (Integer.parseInt(tok.nextToken()) - 1);
						int day = Integer.parseInt(tok.nextToken());
						if (month == today.getMonth() && day== today.getDate()) {
							System.out.println(name + "님 생일축하합니다");
						}
					}
					System.out.println("가입완료\n");
					member.put(tel, new Customer(name, tel, birth, address));
				} else if(ans.equalsIgnoreCase("n")){
					break;
				}else {
					System.out.println("잘못입력하셨습니다.");
					continue;
				}
			}
			String line = "\n";
			String str = "\t\t" + "-----이상 " + member.size() + "명 회원가입-----";
			Iterator<String> iterator = member.keySet().iterator();
			while(iterator.hasNext()) {
				key = iterator.next();
				System.out.println(member.get(key));
			}
			System.out.println("\t\t" + "-----이상 " + member.size() + "명 회원가입-----");
		
		sc.close();
		
	}
}