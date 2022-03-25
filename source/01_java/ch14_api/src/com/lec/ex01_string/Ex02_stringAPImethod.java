package com.lec.ex01_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "      ja   va      ";
		System.out.println("1."+str1.concat(str2));		//���ڿ� ���� : abcXabcABCXabc
		System.out.println("2."+str1.substring(3));		//3���� ���ں��� ��
		System.out.println("3."+str1.substring(3,5));	//3���� ���ں��� 5���� �ձ���
		System.out.println("4."+str1.length());		//���ڱ���7
		System.out.println("5."+str1.toUpperCase());	//�빮�ڷ� ABCXABC
		System.out.println("6."+str1.toLowerCase());	//�ҹ��ڷ� abcxabc
		System.out.println("7."+str1.charAt(3));	//3���� ���� 'X'
		System.out.println("8."+str1.indexOf('b'));	//���� idx 1���
		System.out.println("9."+str1.indexOf('b', 3));	//3������� �˻��ؼ� ù��° 'b'��ġ
		System.out.println("10."+str1.indexOf("abc"));	//"abc"��ġ
		System.out.println("11."+str1.indexOf("abc", 2));	//2������� �˻��ؼ� "abc"��ġ
		System.out.println("12."+str1.indexOf('j'));	//������ -1 
		System.out.println("13."+str1.lastIndexOf('b'));	//������ 'b' idx��ȯ
		System.out.println("14."+str1.lastIndexOf('b', 3));	//3������� ������ ���鼭 bã��
		System.out.println("15."+str1.equals(str2));	//str1�� str2�� ���� ���ڿ����� false(��ҹ��� ����O)
		System.out.println("16."+str1.equalsIgnoreCase(str2));	//��ҹ��� ���о��� �� true
		System.out.println("17."+str3.trim());	//�յ� �������� (�߰�X)
		System.out.println("18."+str1.replace('a', 'b'));	//���ڸ� �ٲ�
		System.out.println("19."+str1.replace("abc", "��"));	//���ڿ��� ����
		System.out.println("20."+str1.replaceAll("abc", "Z"));	
			//����ǥ���� http://goo.gl/HLntbd
				//������ : http://nextree.co.kr/p4327/
			// replaceAll�� cf.replace
			String str = "�ȳ�Hello";		//������ �� *�� �ٲٱ�
			System.out.println("+"+str.replaceAll("[a-zA-Z]", "*"));	//���ĺ��� "*"���� ����
			System.out.println("+"+str.replaceAll("[��-�R]", "*"));	//�ѱ��� "*"���� ����
		//���ڿ� �޼ҵ�� ���ڿ��� ���� ����
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		System.out.println("str3 = "+str3);
		
	}
}
