package com.lec.loop;
//중첩 for문

public class Ex03_for {
	public static void main(String[] args) {
		for(int j=1 ; j<=5 ; j++) { //j가 5회 반복
			for(int i=1; i<=j ; i++) { //i가 1부터 j까지 j회 반복 
				System.out.print('*');
			}//for.i
			System.out.println(); //개행
		}//for.j
	}//main
}//class
