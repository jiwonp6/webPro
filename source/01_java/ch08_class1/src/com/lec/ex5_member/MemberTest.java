package com.lec.ex5_member;
//id, name, email, address, birth, gender
public class MemberTest {

	public static void main(String[] args) {
		Member park = new Member("yeah", "박지원", "yeah@naver.com", "경기도 화성시", "990616", 'w' );
		System.out.println(park.infoString());
		
	}

}
