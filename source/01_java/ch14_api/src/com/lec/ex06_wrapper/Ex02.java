package com.lec.ex06_wrapper;

public class Ex02 {
	public static void main(String[] args) {
		// Wrapper Ŭ������ ���ʵ����͸� ��ü�����ͷ� ��ȯ ���ִ� Ŭ�����̴�.

		double i = 10.1;
		double j = 10.1;
		double sum = i + j;
		System.out.println("���� : " + sum);
		System.out.println(i == j ? "�� double�� ����" : "�� double�� �ٸ���");
		Double iObj = 10.1;
		Double jObj = 10.1;
		sum = iObj + jObj;     // iObj.intValue() + jObj.intValue();
		System.out.println("���� : " + sum);
		System.out.println(iObj.equals(jObj) ? "�� wrapper��ü ���� ����" : "�� wrapper��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");

	}
}
