package com.lec.ex01_string;

import java.util.Scanner;

public class Ex04_quiz01juminNo {
	public static void main(String[] args) {
		String juminNo;
		System.out.println("주민 번호를 입력하세요('-'을 넣어 입력해주세요) :");
		Scanner sc = new Scanner(System.in);
		juminNo = sc.next();
		if(juminNo.charAt(7)=='2'||juminNo.charAt(7)=='4') {
			System.out.println("여자입니다.");
		}else if(juminNo.charAt(7)=='1'||juminNo.charAt(7)=='3') {
			System.out.println("남자입니다.");
		}else
			System.out.println("잘못 입력하셨습니다.");
	}
}
