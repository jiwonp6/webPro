package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("회원을 추가하시겠습니까(y/n)");
			if(!sc.next().equalsIgnoreCase("y")) {
				break;
			}else {
				System.out.println("이름 : ");
				String name = sc.next();
				System.out.println("전화번호 : ");
				String tel = sc.next();
				if(hashMap.get(tel) != null) {
					System.out.println("같은번호가 이미 존재합니다");
					System.out.println(tel+"\t"+hashMap.get(tel));
				}else {
					System.out.println("주소 : ");
					sc.nextLine();
					String address = sc.nextLine();
					String id = name+"\t"+address;
					hashMap.put(tel, id);
				}
			}
		}while(true);	//do
		if(hashMap.size()==0) {
			System.out.println("가입할 회원 없음");
		}else {
			Iterator<String> iterator = hashMap.keySet().iterator();	//hashMap의 keyset(순서지정)
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key+"\t"+hashMap.get(key));
			}
		}//else.last
	}//main
}



