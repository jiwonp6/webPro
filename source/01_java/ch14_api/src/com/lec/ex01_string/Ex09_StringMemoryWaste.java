package com.lec.ex01_string;

public class Ex09_StringMemoryWaste {
	public static void main(String[] args) {
		String str1 ="hello";
		String str2 ="hello";
		System.out.println(str1==str2 ? "같은주소" : "다른주소");
		System.out.println("str1의 해쉬코드 : "+str1.hashCode());
		System.out.println("str2의 해쉬코드 : "+str2.hashCode());
		str1="hello~";
		System.out.println("str1의 해쉬코드 변경후 : "+str1.hashCode());
		System.out.println(str1==str2 ? "같은주소" : "다른주소");
		str1="hello~~";
		System.out.println("str1의 해쉬코드 변경후2 : "+str1.hashCode());
		
	}
}
