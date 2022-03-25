package com.lec.ex01_string;

import java.util.Scanner;

public class Quiz02_tel {
		public static void main(String[] args) {
			String tel;
			System.out.println("전화번호를 입력하세요('-'을 넣어 입력해주세요) :");
			Scanner sc = new Scanner(System.in);
			tel = sc.next();
			do {
				if(idx%2==0) {
					tel.substring(idx)='a';
					}
				}
				
			}while();
	}
}
