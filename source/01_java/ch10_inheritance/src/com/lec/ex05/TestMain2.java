package com.lec.ex05;

public class TestMain2 {
	public static void main(String[] args) {
		Super c1 = new Child1(10);
		System.out.println("c1.s = "+c1.s);
		//System.out.println("c1.c1 = "+c1.c1); <---����Ұ�(c1 Ÿ���� Super�̱� ������ c1 �Ұ�)
		System.out.println("c1.c1 = "+((Child1)c1).c1); //<---����ȯ �ؼ� ����ؾ� ��
	}
}
