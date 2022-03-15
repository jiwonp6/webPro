package com.lec.loop;
//짝수를 입력받는 프로그램 구현
import java.util.Scanner;
public class Ex08_do_while {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("짝수를 입력하세요 : ");
			num = sc.nextInt();
		}while(num%2 != 0);
		System.out.println("입력하신 수는 짝수 "+num+"입니다.");
		sc.close();
	}
}
