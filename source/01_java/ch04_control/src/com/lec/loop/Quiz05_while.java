package com.lec.loop;
//니가 질 때까지 가위바위보게임을 하는 프로그램 구현 
import java.util.Scanner;

public class Quiz05_while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, com;
		do {
			com = (int)(Math.random()*3);
			System.out.println("가위(0), 바위(1), 보(2) 중 하나 선택");
			num = sc.nextInt();
			if (num == 0) {
				System.out.print("당신은 가위\t");
			} else if (num == 1) {
				System.out.print("당신은 바위\t");
			} else if (num == 2) {
				System.out.print("당신은 보자기\t");
			} else {
				System.out.print("당신은 잘못 냈어요. 바이");
				num = 3; // 끝내기 위한 조건
			} // if - you출력
			if (num != 3) { // 컴퓨터가 낸 것과 승패 출력
				String msg = (com == 0) ? "컴이 가위" : (com == 1) ? "컴이 바위" : "컴이 보자기";
				System.out.println(msg);
				// 경우의 수가 3가지 : 졌다, 이겼다, 비겼다
				if( (num+1)%3 == com) {
					System.out.println("당신이 졌어요 ");
					break;
				}else if(num == com ) {
					System.out.println("비겼다");
				}else {
					System.out.println("당신이 이겼어요 ");
				}
			}
			}while(true);
			System.out.println("끝");	
			sc.close();
		}
}
	

