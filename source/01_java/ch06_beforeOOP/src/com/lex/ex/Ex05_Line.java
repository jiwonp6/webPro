package com.lex.ex;
/*return값 X인 경우
 * ■■■■■■■■■■■■■■
 *  Hello, World!
 *  ------------ printLine();
 *  Hello, Java!
 *  ~~~~~~~~~~~~printLine(c);
 *  Hello, Hong!
 * ■■■■■■■■■■■■■■
*/

public class Ex05_Line {
	public static void main(String[] args) {
		printLine('■', 20);
		System.out.println("Hello, World!");
		printLine(20);
		System.out.println("Hello, Java!");
		printLine('~');
		System.out.println("Hello, Hong!");
		printLine('■', 20);
	}
	
//	<메소드>-리턴타입이 없고 매개변수가 없는 메소드(함수)
	private static void printLine(){//return값이 없으므로 void
		for(int i=0; i<15 ; i++) {
			System.out.print('-');
		}
		System.out.println(); //얇은 '-' 15개 출력하고 개행
	}
	
//	<매소드>-함수의 오버로딩(같은 이름의 함수를 매개변수로 구분)
	private static void printLine(char c){
		for(int i=0; i<15 ; i++) {
			System.out.print(c);
		}
		System.out.println(); //매개변수로 받은 c문자 15개 출력하고 개행
	}
	
//	<매소드>-반복되는 횟수 설정
	private static void printLine(int cnt){
		for(int i=0; i<=cnt ; i++) {
			System.out.print('-');
		}
		System.out.println(); //매개변수로 받은 c문자 cnt개 출력하고 개행
	}
	
//	<매소드>-cnt개 출력
	private static void printLine(char c, int cnt){
		for(int i=0; i<=cnt ; i++) {
			System.out.print(c);
		}
		System.out.println(); //매개변수로 받은 c문자 cnt개 출력하고 개행
	}
}
