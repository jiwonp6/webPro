package com.lec.loop;
//1~40���� �� �ٿ� 4���� ���
public class Ex04_for {
	public static void main(String[] args) {
		for(int i=1 ; i<41 ; i++) {
			System.out.print(i+"\t");
			if(i%4==0) {
				System.out.println(); //i�� 4�� ����̸� ���� �߰�
			}//if
		}//for.i
	}//main
}//class
