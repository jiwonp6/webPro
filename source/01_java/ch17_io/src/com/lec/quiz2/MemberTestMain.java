package com.lec.quiz2;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class MemberTestMain {
	public static void main(String[] args) {
		OutputStream fos = null;

		String todayfm = new SimpleDateFormat("MM/dd").format(new Date(System.currentTimeMillis()));
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		String name = null;
		String tel = null;
		String address = null;
		String birth = null;
		// Member member = new Member();

		ArrayList<Member> arrayList = new ArrayList<Member>();
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
					System.out.println("생일((00/00)형식으로 입력바랍니다) :");
					birth = sc.next();
					System.out.println("주소 : ");
					sc.nextLine();
					address = sc.nextLine();
					if(birth.equals(todayfm)) {
						System.out.println(name+"님 생일축하합니다");
					}
					System.out.println("가입완료\n");
					arrayList.add(new Member(name, tel, birth, address));
				} else {
					break;
				}
			}
			String line = "\n";
			String str = "\t\t" + "-----이상 " + arrayList.size() + "명 회원가입-----";
			for (int i = 0; i < arrayList.size(); i++) {
				fos.write(arrayList.get(i).toString().getBytes());
				System.out.println(arrayList.get(i));
				fos.write(line.getBytes());
			}
			fos.write(str.getBytes());
			
			System.out.println("\t\t" + "-----이상 " + arrayList.size() + "명 회원가입-----");
			arrayList.clear();
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
