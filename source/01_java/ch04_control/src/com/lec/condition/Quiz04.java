package com.lec.condition;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		int num;
		String ans;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위 바위 보를 숫자로 입력하세요 : \n(가위는 0, 바위는 1, 보는 2 입니다.)");
		num = sc.nextInt();
		if(num==0) {
			System.out.println("가위");
		}else if(num==1){
			System.out.println("바위");
		}else if(num==2){
			System.out.println("보");
		}else
			System.out.println("유효하지 않은 값입니다.");
		sc.close();
	}
}
