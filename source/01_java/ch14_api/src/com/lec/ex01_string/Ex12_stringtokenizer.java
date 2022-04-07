package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_stringtokenizer {
	public static void main(String[] args) {
		String str1 = "�ں��� ���� ���� ��ҿ� �嵿��";
		String str2 = "2022/03/28";
		StringTokenizer tokenizer1 = new StringTokenizer(str1);	//space�� �������� ���ڿ� ����
		System.out.println("tokenizer1�� ��ū ���� : "+tokenizer1.countTokens());
		while(tokenizer1.hasMoreTokens()) {
			System.out.println(tokenizer1.nextToken());	//
		}
		StringTokenizer tokenizer2 = new StringTokenizer(str2, "/");	// "/"�� �������� ���ڿ��� ����
		System.out.println("tokenizer2�� ��ū ���� : "+tokenizer2.countTokens());
		while(tokenizer2.hasMoreElements()) {
			System.out.println(tokenizer2.nextToken());
		}
	}
}
