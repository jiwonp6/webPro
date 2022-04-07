package com.lec.quiz;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		String ans;
		String address = null;
		int i;
		Friend[] f1 = { new Friend("홍길동", "서울시 용산구", "010-9999-1234", "05-22"),
				new Friend("신길동", "경기도 화성시", "010-8888-5678", "04-07"),
				new Friend("김길동", "서울시 강남구", "010-9999-8524", "08-08")};

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("검색할 주소 앞 글자 2자리 (단, 종료를 원하시면 x를 입력하시오) : ");
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
					System.out.println("해당 주소의 친구는 없습니다.\n");
				}
			}else {
				System.out.println("종료");
				break;
			}
		}
	}
}
