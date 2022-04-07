package com.lec.quiz2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain3 {
	public static void main(String[] args) {
		OutputStream fos = null;

		String todayfm = new SimpleDateFormat("MM/dd").format(new Date(System.currentTimeMillis()));
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		Scanner sc = new Scanner(System.in);

		String name = null;
		String tel = null;
		String address = null;
		String birth = null;
		Date today = new Date();
		Integer key;
		
		HashMap<Integer, Member> member = new HashMap<Integer, Member>();
		try {
			fos = new FileOutputStream("src/com/lec/quiz2/member.txt");
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
					member.put(member.size(), new Member(name, tel, birth, address));
				} else {
					break;
				}
			}
			String line = "\n";
			String str = "\t\t" + "-----이상 " + member.size() + "명 회원가입-----";
			Iterator<Integer> iterator = member.keySet().iterator();
			while(iterator.hasNext()) {
				key = iterator.next();
				fos.write(member.get(key).toString().getBytes());
				System.out.println(member.get(key));
				fos.write(line.getBytes());
			}
			fos.write(str.getBytes());
			System.out.println("\t\t" + "-----이상 " + member.size() + "명 회원가입-----");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (Exception ignore) {
			}
		}
		sc.close();
	}
}