package com.lec.quiz;
//ArrayList
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		ArrayList<Member> mbs = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("회원을 추가하시겠습니까(y/n)");
			if(!sc.next().equalsIgnoreCase("y")) {
				break;
			}else{
			System.out.println("이름 : ");
			String name = sc.next();
			System.out.println("전화번호 : ");
			String tel = sc.next();
			System.out.println("주소 : ");
			sc.nextLine();
			String address = sc.nextLine();
			mbs.add(new Member(name, tel, address));
			}
		}while(true);
		if(mbs.size()==0) {
			System.out.println("가입할 회원 없음");
		}else {
			for(int i=0; i<mbs.size(); i++) {
				System.out.println(mbs);
			}
		}
	}
}
