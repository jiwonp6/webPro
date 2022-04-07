package com.lec.quiz;

import java.util.Scanner;

public class TestMain{
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "05-22"),
							new Friend("신길동", "010-8888-8888", "09-22"),
							new Friend("마길동", "010-7777-8888", "08-22")};
	
		Scanner sc = new Scanner(System.in);
		String searchTel = null;
		int idx=0;
		while(true) {
			System.out.println("검색할 전화번호 뒷자리(단, 종료를 원하면 x를 입력하시오) : ");
			searchTel = sc.next();
			boolean searchOk = false;	
			for(idx=0; idx<friends.length; idx++) {
				String tel = friends[idx].getTel();
				String post = tel.substring(tel.lastIndexOf('-')+1);
				if(post.equals(searchTel)) {
					System.out.println(friends[idx]);
					searchOk = true;
				}
			}
			if(!searchOk)	{	
				System.out.println("검색하신 전화번호는 없습니다.");
			}
		}
		//sc.close();
	}
}
