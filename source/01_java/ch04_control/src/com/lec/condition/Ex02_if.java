package com.lec.condition;
//사용자로부터 두 수를 입력받아 첫 번째 수가 더 큰지 두번째 수가 더 큰지 출력

import java.util.Scanner;

public class Ex02_if {
	public static void main(String[] args) {
		int num1, num2;
		//int i = 10;
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수는 : ");
		num1 = sc.nextInt(); // 정수 입력하고 엔터를 누르면 해당 정수가 num1에 할당
		System.out.print("두 번째 수는 : ");
		num2 = sc.nextInt();
		
		if(num1 > num2){
			System.out.println("첫 번째 수가 "+(num1-num2)+"만큼 더 큽니다.");
		}
		else if(num2 > num1){
			System.out.printf("두 번째 수가 %d만큼 더 큽니다.\n", (num2-num1));
		} 
		else{
			System.out.println("입력한 두 수는 같습니다.");
		}
		
	}
}
