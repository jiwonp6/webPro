package com.lec.ex01_trycatch;

public class Ex04_finally {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2 };
		for (int i = 0; i <= arr.length; i++) { // 배열에 인덱스3번이 없어서 에러
			try {
			System.out.println("arr[" + i + "] = " + arr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지 : "+ e.getMessage());
			} finally { // 예외가 발생하지 않아도 실행, 예외가 발생해도 실행  반드시 실행 됌
				System.out.println("try절 실행 후에도 catch절 실행후에도 여기는 결국 반드시 실행");
			}
		}
		System.out.println("프로그램 끝");
	}

}
