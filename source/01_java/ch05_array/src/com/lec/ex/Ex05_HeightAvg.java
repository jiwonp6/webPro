package com.lec.ex;

import java.util.Scanner;
// 1. 사용자로 부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아 평균키 출력
public class Ex05_HeightAvg {
	public static void main(String[] args) {
		String[] arrName = {"영희", "철수", "길동", "영수", "말자"};
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0;	// 입력받은 키 누적 변수
		for(int idx=0 ; idx < arrName.length ; idx++) {
			System.out.print(arrName[idx]+"의 키는 : ");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("평균키는 "+(double)totalHeight/arrName.length);
		
		sc.close();
	}
}
