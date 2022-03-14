package com.lec.condition;

import java.util.Scanner;

public class Ex04_switch_hakjum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수 : ");
		int score = scanner.nextInt();
		int temp = score==100? score-1 : score; //100점인 경우 case10으로 인식되므로 선별해줌
		temp = (-9<=temp && temp<0) ? -10 : temp; //-9에서 -1까지 case1로 인식되므로 선별해줌
		
		switch(score/10) {
			// case 10 : //100점일 경우 case10은 break없어서 case9로 실행됨 cf.101점인 경우
			case 9 : System.out.println("A학점"); break;
			case 8 : System.out.println("B학점"); break;
			case 7 : System.out.println("C학점"); break;
			case 6 : System.out.println("D학점"); break;
			case 5 : case 4: case 3 : case 2 : case 1 : case 0 :
				 	 System.out.println("F학점"); break;
			default : 
				System.out.println("유효하지 않는 점수입니다.");
		}
		scanner.close();
	}
}
