package com.lec.ex01_string;

public class Ex09_StringMemoryWaste {
	public static void main(String[] args) {
		String str1 ="hello";
		String str2 ="hello";
		System.out.println(str1==str2 ? "�����ּ�" : "�ٸ��ּ�");
		System.out.println("str1�� �ؽ��ڵ� : "+str1.hashCode());
		System.out.println("str2�� �ؽ��ڵ� : "+str2.hashCode());
		str1="hello~";
		System.out.println("str1�� �ؽ��ڵ� ������ : "+str1.hashCode());
		System.out.println(str1==str2 ? "�����ּ�" : "�ٸ��ּ�");
		str1="hello~~";
		System.out.println("str1�� �ؽ��ڵ� ������2 : "+str1.hashCode());
		
	}
}
