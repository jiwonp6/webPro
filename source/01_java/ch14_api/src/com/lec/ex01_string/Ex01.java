package com.lec.ex01_string;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		String str1 = "Java";
		String str2 = "Java";
		String str3 = new String("Java");	//무조건 객체 생성
		//String은 new로 생성하지 않고 " "를 사용한 문자열 상수를 이용
		//자동으로 heap 영역에 String 객체 생성됨
			//->(이때, 이미 존재하는지 확인 후 존재하면 같이 공유해서 씀)
				//->(존재하지 않으면 String 객체 생성)
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소값이 있음");
		}else {
			System.out.println("str1과 str2는 다름 주소값이 있음");
		}
		if(str1.equals(str2)) {
			System.out.println("같은 문자열");
		}
		System.out.println(str1==str3 ? "str1과 str3은 같은 주소값" : "str1과 str3은 다른 주소값");
		System.out.println(str1.equals(str3) ? "str1과 str3은 같은 스트링" : "str1과 str3은 다른 문자열");
	}
}
