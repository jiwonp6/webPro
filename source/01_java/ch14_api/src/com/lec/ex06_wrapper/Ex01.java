package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		// Wrapper Ŭ������ ���ʵ����͸� ��ü�����ͷ� ��ȯ ���ִ� Ŭ�����̴�.

		int i = 10;
		int j = 10;
		int sum = i + j;
		System.out.println("���� : " + sum);
		System.out.println(i == j ? "�� int�� ����" : "�� int�� �ٸ���");
		Integer iObj = new Integer(10);
		Integer jObj = 10; // ���Ʒ� �Ѵ� �ᱹ 10
		sum = iObj.intValue() + jObj.intValue();
		System.out.println("���� : " + sum);
		System.out.println(iObj.equals(jObj) ? "�� wrapper��ü ���� ����" : "�� wrapper��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");

		// if ( s.equals(i)) { // ������ ������ �̷����� �˾Ƽ� ��ü������ ��ȯ���� s.equals(new Integer(10))

	}
}
