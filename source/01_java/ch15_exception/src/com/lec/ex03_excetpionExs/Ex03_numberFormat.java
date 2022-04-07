package com.lec.ex03_excetpionExs;

import java.util.Scanner;

public class Ex03_numberFormat {

	public static void main(String[] args) {
//		int i = Integer.parseInt(""); // 빈스트링은 숫자로 변환 안됨 그리고 예외발생
		int i = Integer.parseInt("100 ".trim()); // space가 들어가도 예외발생됨 그래서 없애줘야함
		System.out.println(i);

	}

}
