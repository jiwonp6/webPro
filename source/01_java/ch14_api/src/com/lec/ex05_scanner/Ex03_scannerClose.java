package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {
	private static void nickName() { // 사용자로부터 별명을 받아 출력하는 메소드
		Scanner scNickName = new Scanner(System.in);
		System.out.print("별명을 입력하세요 : ");
		System.out.println("입력하신 별명은 : "+ scNickName.nextLine());
		
	}
	
	public static void main(String[] args) {
		 // BookLib 객체 만들어서 사용자에게 대출 or 반납
		Scanner scMain = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = scMain.nextLine();
		System.out.println("입력하신 이름은 : "+ name);
		nickName();
		System.out.print("나이를 입력하세요 : ");
		int age = scMain.nextInt();
		System.out.println("입력하신 나이는 : "+ age);
		scMain.close();
		
		
		
	}

}
