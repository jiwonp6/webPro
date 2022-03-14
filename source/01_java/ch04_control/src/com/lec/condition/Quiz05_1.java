package com.lec.condition;

import java.util.Scanner;
//0<=Math.random()<1
//0<=Math.random()*3<3
//0<=(int)(Math.random()*3)<3	: 0, 1, 2 중 하나
	public class Quiz05_1 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int num, com = (int)(Math.random()*3);
			System.out.println("가위(0), 바위(1), 보(2) 중 하나 선택");
			num = sc.nextInt(); //정수 입력받기
			if(num==0) {
				System.out.println("가위\t");
			}else if(num==1){
				System.out.println("바위\t");
			}else if(num==2){
				System.out.println("보\t");
			}else {
				System.out.println("잘못 냈어요. 바이");
				num=3;	//끝내기 위한 조건
			}
			if(num !=3) {
				String msg = (com==0) ? "컴퓨터는 가위": (com==1) ? "컴퓨터는 바위" : "컴퓨터는 보";
				System.out.println(msg);
				//승패출력
				}
			
			if((num+2)%3==com) {
				System.out.println("당신이 이겼다.");
			}else if(num==com){
				System.out.println("비겼다.");
			}else {
				System.out.println("컴퓨터가 이겼다.");
			}//if-승패출력
			
			sc.close();
	}//main
}//class

