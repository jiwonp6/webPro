package com.lec.condition;

public class Ex03_switch {
	public static void main(String[] args) {
		int num1=2;
		switch(num1) {//정수형, 문자형, 문자열 만 가능
		case 1 : System.out.println("1입니다."); break;
		case 2 : System.out.println("2입니다."); break;
		case 3 : System.out.println("3입니다."); break;
		default : System.out.println("그 외의 수입니다.");
		}
	}
}
