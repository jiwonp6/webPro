package com.lex.ex;
/*return�� X�� ���
 * ���������������
 *  Hello, World!
 *  ------------ printLine();
 *  Hello, Java!
 *  ~~~~~~~~~~~~printLine(c);
 *  Hello, Hong!
 * ���������������
*/

public class Ex05_Line {
	public static void main(String[] args) {
		printLine('��', 20);
		System.out.println("Hello, World!");
		printLine(20);
		System.out.println("Hello, Java!");
		printLine('~');
		System.out.println("Hello, Hong!");
		printLine('��', 20);
	}
	
//	<�޼ҵ�>-����Ÿ���� ���� �Ű������� ���� �޼ҵ�(�Լ�)
	private static void printLine(){//return���� �����Ƿ� void
		for(int i=0; i<15 ; i++) {
			System.out.print('-');
		}
		System.out.println(); //���� '-' 15�� ����ϰ� ����
	}
	
//	<�żҵ�>-�Լ��� �����ε�(���� �̸��� �Լ��� �Ű������� ����)
	private static void printLine(char c){
		for(int i=0; i<15 ; i++) {
			System.out.print(c);
		}
		System.out.println(); //�Ű������� ���� c���� 15�� ����ϰ� ����
	}
	
//	<�żҵ�>-�ݺ��Ǵ� Ƚ�� ����
	private static void printLine(int cnt){
		for(int i=0; i<=cnt ; i++) {
			System.out.print('-');
		}
		System.out.println(); //�Ű������� ���� c���� cnt�� ����ϰ� ����
	}
	
//	<�żҵ�>-cnt�� ���
	private static void printLine(char c, int cnt){
		for(int i=0; i<=cnt ; i++) {
			System.out.print(c);
		}
		System.out.println(); //�Ű������� ���� c���� cnt�� ����ϰ� ����
	}
}
