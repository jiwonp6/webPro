package com.lec.ex01_string;
//배열에 있는 전화번호 찾아 전체 전화번호 출력
import java.util.Scanner;

public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel;	//사용자로부터 전화번호 뒷번호 입력받은 데이터 할당
		boolean searchOk = false;	
		int idx=0;
		System.out.println("검색하고자 하는 회원의 전화번호 뒷자리는?");
		searchTel = sc.next();
		for(idx=0; idx<tels.length; idx++) {
			//전화번호 뒷자리 추출
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("검색하신 전화번호는 "+tels[idx]+"입니다.");
				searchOk = true;	//break 쓸 경우 제일 처음으로 일치하는 번호 1개만 나옴
			}//if- 전화번호 찾을 경우 더이상 검색하지 않고 for문 빠져나감.
		}//for
		if(!searchOk)	{	//searchTel이 배열 전화에 없어서 못찾고 idx 끝까지 가서 종료
			System.out.println("검색하신 전화번호는 없습니다.");
		}
	
	
	}
}
