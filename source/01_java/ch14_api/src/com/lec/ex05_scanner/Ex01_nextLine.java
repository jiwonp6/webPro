package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01_nextLine {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = scanner.nextInt();
		System.out.println("입력하신 나이는 : "+ age);
		
		System.out.print("이름을 입력하세요 : ");
		String name = scanner.next();
		System.out.println("입력하신 이름은 "+ name);
		
		System.out.println("주소를 입력하세요 : ");
		scanner.nextLine(); //  버퍼에 남아 있는 '\n'을 지우는 목적
		String address = scanner.nextLine();  // '\n'앞에 있는 값을 return 하고 '\n' 부터는 지운다.
		System.out.println("입력하신 주소는 : "+ address);  // address = "" 빈 스트링 값
		scanner.close();
	}
	// next() 는 스페이스포함 x 입력한것 출력해주고
	// nextLine() 은 스페이스포함 o 해서 입력한것 출력해줌 \n 뒤에있는것 전부
	// 엔터 = \n 
	

}
