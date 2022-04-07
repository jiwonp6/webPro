package com.lec.ex01_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println("�ؽ��ڵ� ��� : "+str.hashCode());
		str =str + "d";
		System.out.println("�ؽ��ڵ� �ٲ� ��� : "+str.hashCode());
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("�ؽ��ڵ� ���2 : "+strBuilder.hashCode());
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.append("def");	//abc�� def �߰�
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.insert(3, "AAA");	//3��°�� "AAA" �߰� abcAAAdef
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.delete(3, 5);	//3~5��° �ձ��� ���� : abcAdef
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("�ؽ��ڵ� ��� : "+strBuilder.hashCode());
		strBuilder.deleteCharAt(3);	//3��° ���ڸ� ���� delete(3,4)
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("�ؽ��ڵ� ��� : "+strBuilder.hashCode());
	}
	
}
